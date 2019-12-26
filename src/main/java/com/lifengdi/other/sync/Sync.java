package com.lifengdi.other.sync;

/**
 * @author 李锋镝
 * @date Create at 10:15 2019/12/26
 */
public class Sync {

    public static synchronized void a() {
        System.out.println(Thread.currentThread().getName() +
                "-----static-A开始" + System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "a error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName()
                + "-----static-A结束"
                + System.currentTimeMillis());
    }

    public static synchronized void b() {
        System.out.println(Thread.currentThread().getName() + "-----static-B开始" + System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "b error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName()
                + "-----static-B结束" + System.currentTimeMillis());
    }

    public synchronized void c() {
        System.out.println(Thread.currentThread().getName() + "------C开始" + System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "c error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName() +
                "------C结束" + System.currentTimeMillis());
    }

    public synchronized void d() {
        System.out.println(Thread.currentThread().getName() + "------D开始" + System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "d error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName() +
                "------D结束" + System.currentTimeMillis());
    }

    public static synchronized void e() {
        System.out.println(Thread.currentThread().getName() +
                "-----static-E开始" + System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "e error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName()
                + "-----static-E结束"
                + System.currentTimeMillis());
    }

    public synchronized void f() {
        System.out.println(Thread.currentThread().getName() +
                "------f开始" + System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
            e();
        } catch (Exception e) {
            System.err.println(Thread.currentThread().getName() + "f error" + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName()
                + "------f结束"
                + System.currentTimeMillis());
    }

}
