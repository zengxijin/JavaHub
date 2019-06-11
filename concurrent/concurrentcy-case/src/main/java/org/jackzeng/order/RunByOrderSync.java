package org.jackzeng.order;

import java.util.concurrent.TimeUnit;

/**
 * @author xijin.zeng created on 2019/6/10
 */
public class RunByOrderSync {

    private static final Object a = new Object();
    private static final Object b = new Object();
    private static final Object c = new Object();

    public static class RunTask implements Runnable {

        private String code;
        private Object current;
        private Object previous;

        public RunTask(String code, final Object current, final Object previous) {
            this.code = code;
            this.current = current;
            this.previous = previous;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (previous) {
                    synchronized (current) {
                        System.out.println(code);
                        current.notify();
                    }

                    try {
                        previous.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 这个设计非常依赖于线程的启动顺序，如果启动顺序错了，那就是乱序的
     * 而线程的启动顺序在并发的代码里是无法保证按照代码启动的顺序的，因为由JVM来调度
     * 比较笨的实现方式就是当前线程sleep一段时间，让代码有足够的时间启动完成之前的线程
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunTask("A", a, c));
        t1.start();
        TimeUnit.MILLISECONDS.sleep(10);

        Thread t2 = new Thread(new RunTask("B", b, a));
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);

        Thread t3 = new Thread(new RunTask("C", c, b));
        t3.start();
    }

}
