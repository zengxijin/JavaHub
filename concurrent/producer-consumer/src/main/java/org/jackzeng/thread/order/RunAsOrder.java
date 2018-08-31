package org.jackzeng.thread.order;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xijin.zeng created on 2018/8/31
 * running order A->B->C
 */
@Data
public class RunAsOrder {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition conditionA = reentrantLock.newCondition();
    private final Condition conditionB = reentrantLock.newCondition();
    private final Condition conditionC = reentrantLock.newCondition();

    private final Condition condition = reentrantLock.newCondition();

    /**
     * init for A to run
     */
    private volatile int flag = 'A';

    class ThreadA implements Runnable {

        private RunAsOrder context;

        public ThreadA(RunAsOrder context) {
            this.context = context;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    reentrantLock.lock();
                    task();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        private void task() throws InterruptedException {
            if (flag != 'A') {
                conditionA.await();
                condition.signalAll();
            }

            System.out.println("A");

            // signal B to run
            context.flag = 'B';
            conditionB.signal();
        }
    }

    class ThreadB implements Runnable {

        private RunAsOrder context;

        public ThreadB(RunAsOrder context) {
            this.context = context;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    reentrantLock.lock();
                    task();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        private void task() throws InterruptedException {
            if (flag != 'B') {
                conditionB.await();
                condition.signalAll();
            }

            System.out.println("B");

            // signal C to run
            context.flag = 'C';
            conditionC.signal();
        }
    }

    class ThreadC implements Runnable {

        private RunAsOrder context;

        public ThreadC(RunAsOrder context) {
            this.context = context;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    reentrantLock.lock();
                    task();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        private void task() throws InterruptedException {
            if (flag != 'C') {
                conditionC.await();
                condition.signalAll();
            }

            System.out.println("C");

            // signal A to run
            context.flag = 'A';
            conditionA.signal();
        }
    }

    public void runTest() {

        Thread a = new Thread(new ThreadA(this));
        Thread b = new Thread(new ThreadB(this));
        Thread c = new Thread(new ThreadC(this));

        a.start();
        b.start();
        c.start();
    }

    public static void main(String[] args) {
        RunAsOrder runner = new RunAsOrder();
        runner.runTest();
    }
}
