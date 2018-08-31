package org.jackzeng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xijin.zeng created on 2018/7/17
 */
public class ConditionPC {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] buffer = new Object[100];
    private int putIndex;
    private int takeIndex;
    private int count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("put");
            while (count == buffer.length) {
                System.out.println("buffer full await");
                notFull.await();
            }

            System.out.println("put:" + x);
            buffer[putIndex] = x;
            count++;

            if (++putIndex == buffer.length) {
                putIndex = 0;
            }
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("take");
            while (count == 0) {
                System.out.println("buffer empty await");
                notEmpty.await();
            }

            Object x = buffer[takeIndex];
            count--;
            System.out.println("take:" + x);

            if (++takeIndex == buffer.length) {
                takeIndex = 0;
            }
            notFull.signal();

            return x;

        } finally {
            lock.unlock();
        }
    }
}
