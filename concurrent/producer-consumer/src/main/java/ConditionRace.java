import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xijin.zeng created on 2018/7/17
 */
public class ConditionRace {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final Object[] buffer = new Object[100];
    private int putIndex, takeIndex, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == buffer.length) {
                System.out.println("full buffer");
                condition.await();
            }

            buffer[putIndex] = x;
            count++;
            if (++putIndex == buffer.length) {
                putIndex = 0;
            }
            System.out.println("put " + x);

            condition.signal();

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("buffer empty");
                condition.await();
            }

            Object x = buffer[takeIndex];
            count--;
            if (++takeIndex == buffer.length) {
                takeIndex = 0;
            }
            System.out.println("take " + x);

            condition.signal();

            return x;
        } finally {
            lock.unlock();
        }
    }
}
