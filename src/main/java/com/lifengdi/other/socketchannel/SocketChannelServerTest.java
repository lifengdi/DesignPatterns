package com.lifengdi.other.socketchannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author 李锋镝
 * @date Create at 14:06 2019/12/24
 */
public class SocketChannelServerTest {

    public static void main(String []a) {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8080));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if(selector.select(3000) == 0){
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    System.out.println(key);
                    if(key.isAcceptable()){
                        System.out.println("isAcceptable");
                        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
                        SocketChannel sc = ssChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(1024));
                    }
                    if(key.isReadable()){
                        System.out.println("isReadable");
                        SocketChannel sc = (SocketChannel)key.channel();
                        ByteBuffer buf = (ByteBuffer)key.attachment();
                        long bytesRead = sc.read(buf);
                        while(bytesRead>0){
                            buf.flip();
                            while(buf.hasRemaining()){
                                System.out.print((char)buf.get());
                            }
                            System.out.println();
                            buf.clear();
                            bytesRead = sc.read(buf);
                        }
                        if(bytesRead == -1){
                            sc.close();
                        }
                    }
                    if(key.isWritable() && key.isValid()){
                        System.out.println("isWritable");
                        ByteBuffer buf = (ByteBuffer)key.attachment();
                        buf.flip();
                        SocketChannel sc = (SocketChannel) key.channel();
                        while(buf.hasRemaining()){
                            sc.write(buf);
                        }
                        buf.compact();
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
