package org.jackzeng.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xijin.zeng created on 2019/6/10
 */
public class CyclicBarrierCase {

    private final AtomicInteger threadStarted = new AtomicInteger(0);
    private final AtomicInteger threadDone = new AtomicInteger(0);

    private final int THREAD_NUM = 32;

    public void start() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier gate = new CyclicBarrier(THREAD_NUM + 1);

        for (int i = 1; i <= THREAD_NUM; i++) {
            Thread thread = new Thread(
                    () -> {
                        String name = "t-" + threadStarted.incrementAndGet();
                        Thread.currentThread().setName(name);
                        System.out.println(name + " is waiting...");
                        // start and wait
                        try {
                            gate.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }

                        // concurrent running code
                        System.out.println("done count: " + threadDone.incrementAndGet());
                        System.out.println(Thread.currentThread().getName() + " is done");
                    }
            );
            thread.start();
        }

        // main thread is waiting
        System.out.println("main thread is waiting...");
        gate.await();
        System.out.println("main thread is done");
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrierCase barrierCase = new CyclicBarrierCase();
        barrierCase.start();
    }
}
