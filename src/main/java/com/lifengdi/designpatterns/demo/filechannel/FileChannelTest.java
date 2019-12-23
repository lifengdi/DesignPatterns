package com.lifengdi.designpatterns.demo.filechannel;

import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 李锋镝
 * @date Create at 10:51 2019/12/23
 */
public class FileChannelTest {
    private static final String FROM = "/Users/goddess/test.zip";
    private static final String TO = "/Users/goddess/test2.zip";
    public static void main(String[] args) {
        fileCopyNormal();
        channel();
        mmap();
    }

    private static void channel() {
        FileChannel in = null, out = null;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            in = new RandomAccessFile(FROM, "r").getChannel();
            out = new RandomAccessFile(TO, "rw").getChannel();
            in.transferTo(0, in.size(), out);
            stopWatch.stop();
            System.out.println("channel:" + stopWatch.getTotalTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void mmap() {
        FileChannel in = null, out = null;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            in = new RandomAccessFile(FROM, "rw").getChannel();
            out = new RandomAccessFile(TO, "rw").getChannel();
            MappedByteBuffer map = in.map(FileChannel.MapMode.READ_WRITE, 0, in.size());
            out.write(map);
            stopWatch.stop();
            System.out.println("mmap:" + stopWatch.getTotalTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void fileCopyNormal() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(FROM)));
            outputStream = new BufferedOutputStream(new FileOutputStream(new File((TO))));
            byte[] bytes = new byte[4096];
            int i;
            //读取到输入流数据，然后写入到输出流中去，实现复制
            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
            stopWatch.stop();
            System.out.println("Normal:" + stopWatch.getTotalTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
