package org.jackzeng.thread.order;

/**
 * @author xijin.zeng created on 2018/8/31
 */
public class ThreadOrderWithSync {

    private volatile int flag = 'A';
    private final static Object LOCK = new Object();

    Runnable a = () -> {
        while (true) {
            synchronized (LOCK) {
                if (flag == 'A' ) {
                    System.out.println("A");

                    flag = 'B';
                    // let other thread race to get the monitor
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Runnable b = () -> {
        while (true) {
            synchronized (LOCK) {
                if (flag == 'B' ) {
                    System.out.println("B");

                    flag = 'C';
                    // let other thread race to get the monitor
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Runnable c = () -> {
        while (true) {
            synchronized (LOCK) {
                if (flag == 'C' ) {
                    System.out.println("C");

                    flag = 'A';
                    // let other thread race to get the monitor
                    LOCK.notifyAll();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public void runTest() {
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        Thread tc = new Thread(c);

        ta.start();
        tb.start();
        tc.start();
    }

    public static void main(String[] args) {
        ThreadOrderWithSync sync = new ThreadOrderWithSync();
        sync.runTest();
    }
}
