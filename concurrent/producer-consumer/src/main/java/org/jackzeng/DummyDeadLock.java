package org.jackzeng;

/**
 * @author xijin.zeng created on 2018/7/18
 */
public class DummyDeadLock {

    public static void main(String[] args) {
        DummyDeadLock.demo();
    }

    private final String s1 = "A";
    private final String s2 = "B";

    public void syncS1S2() {
        System.out.println("enter syncS1S2");
        while (true) {
            synchronized (s1) {
                System.out.println("lock s1");
                synchronized (s2) {
                    System.out.println("lock s2");
                }
            }
        }
    }

    public void syncS2S1() {
        System.out.println("enter syncS2S1");
        while (true) {
            synchronized (s2) {
                System.out.println("lock s2");
                synchronized (s1) {
                    System.out.println("lock s1");
                }
            }
        }
    }

    public static void demo() {
        final DummyDeadLock dummyDeadLock = new DummyDeadLock();
        Runnable r1 = dummyDeadLock::syncS1S2;
        Runnable r2 = dummyDeadLock::syncS2S1;

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
