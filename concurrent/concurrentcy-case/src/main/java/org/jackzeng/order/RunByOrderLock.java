package org.jackzeng.order;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xijin.zeng created on 2019/6/10
 */
public class RunByOrderLock {

    private static ReentrantLock lock = new ReentrantLock();
//    private Condition signal = lock.newCondition();
    private static final Condition a = lock.newCondition();
    private static final Condition b = lock.newCondition();
    private static final Condition c = lock.newCondition();
    private static volatile boolean signal = false; // first start
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread r1 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (signal) {
                        a.await();
                    }
                    System.out.println(counter.incrementAndGet());
                    System.out.println("A");
                    signal = true;
                    b.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread r2 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    b.await();
                    System.out.println("B");
                    c.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread r3 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    c.await();

                    System.out.println("C");
                    a.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        // make a start first
        System.out.println("start...");
        r3.start();
        TimeUnit.MILLISECONDS.sleep(10);
        r2.start();
        TimeUnit.MILLISECONDS.sleep(10);
        r1.start();
        TimeUnit.MILLISECONDS.sleep(10);

    }
}
