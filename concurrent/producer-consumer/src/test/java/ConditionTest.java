import org.junit.Test;

/**
 * @author xijin.zeng created on 2018/7/17
 */
public class ConditionTest {
    public static void main(String[] args) {
        ConditionRace pc = new ConditionRace();

        Runnable r1 = () -> {
            for (int i=0; i < 600; i++) {
                try {
                    pc.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            try {
                while (true) {
                    pc.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
