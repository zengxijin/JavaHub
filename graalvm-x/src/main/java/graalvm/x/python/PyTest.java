package graalvm.x.python;

import com.google.common.base.Stopwatch;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.concurrent.TimeUnit;

/**
 * @author zengxijin created on 2019-11-22
 */
public class PyTest {

    private static String PYTHON = "python";

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println("create context");
        Context context = Context.create();
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

        String pyPrint = "print('Hi, Python!')";
        String pySum = "10 + 20";

        // first running
        stopwatch.reset().start();
        System.out.println("running script first");
        // 第一次跑需要预编译和缓存
        context.eval(PYTHON, pySum);
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

        System.out.println("running script second");
        stopwatch.reset().start();
        context.eval(PYTHON, pySum);
//        for (int i = 10; i > 0; i--) {
//            // 默认是context域的脚步预编译缓存
//            context.eval("python", "print('Hi, Python!')");
//        }
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));


        // destroy
        context.close();

        evalFunction("lambda x: x + 1", 10);
    }

    public static void evalFunction(String pyFunction, Object params) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try (Context context = Context.create()) {
            Value fun = context.eval(PYTHON, pyFunction);
            if (fun.canExecute()) {
                int x1 = fun.execute(params).asInt(); // first compile and run
                System.out.println("first eval time:" + x1 + " sec:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));

                stopwatch.reset().start();
                int x2 = fun.execute(x1).asInt(); // just run from cache
                System.out.println("second eval time:" + x2 + " sec:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
            }
        }
    }
}
