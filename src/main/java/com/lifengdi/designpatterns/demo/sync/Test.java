package com.lifengdi.designpatterns.demo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李锋镝
 * @date Create at 10:14 2019/12/26
 */
public class Test {
    public static void main(String[] a) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 同一个实例，静态方法共用一个锁，非静态方法共用这个实例的锁
//        Sync sync = new Sync();
//        executorService.execute(() -> sync.a());
//        executorService.execute(() -> sync.b());
//        executorService.execute(() -> sync.c());
//        executorService.execute(() -> sync.d());
//
//        System.out.println("---------分割线------------");
//
//        // 同一个对象中静态方法共用一个锁
//        executorService.execute(Sync::a);
//        executorService.execute(Sync::b);
//
//        System.out.println("---------分割线2------------");
//        executorService.execute(() -> {
//            Sync s = new Sync();
//            s.a();
//        });
//        executorService.execute(() -> {
//            Sync s = new Sync();
//            s.b();
//        });
//
//        System.out.println("---------分割线3------------");
//        // 不同的实例，非静态方法锁得是各自的实例化对象
//        executorService.execute(() -> {
//            Sync s = new Sync();
//            s.c();
//        });
//        executorService.execute(() -> {
//            Sync s = new Sync();
//            s.d();
//        });

        System.out.println("---------分割线4------------");
        // 不同得实例，非静态方法锁得是各自的实例化对象
        executorService.execute(() -> {
            Sync s = new Sync();
            s.f();
        });
        executorService.execute(() -> {
            Sync s = new Sync();
            s.e();
        });

        executorService.shutdown();
        try {
            // 等待所有线程处理完 然后返回结果
            while (!executorService.isTerminated()) {
                Thread.sleep(10L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
