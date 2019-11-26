package graalvm.x.python;

import com.google.common.base.Charsets;
import com.google.common.base.Stopwatch;
import com.google.common.io.Resources;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zengxijin created on 2019-11-22
 */
public class PyTest {

    private static String PYTHON = "python";

    public static void main(String[] args) throws IOException {
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

        // evalFunction("lambda x: x + 1", 10);

        // loadFile();

        // accessJavaObj();
        accessGuestObj();
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

    private static void loadFile() throws IOException {
        String pyContent = Resources.toString(Resources.getResource("py_01.py"), Charsets.UTF_8);
        System.out.println(pyContent);

        Stopwatch watch = Stopwatch.createStarted();
        Context.Builder builder = Context.newBuilder();
        builder.allowAllAccess(true);
        Context context = builder.build();

        Source source = Source.create(PYTHON, pyContent);
        context.eval(source);

        Value pyFunc = context.getPolyglotBindings().getMember("foo");
        if (pyFunc.canExecute()) {
            int retInt = pyFunc.execute(100).asInt();
            System.out.println(retInt);
            System.out.println("first: " + watch.stop().elapsed(TimeUnit.MILLISECONDS));

            watch.reset().start();
            int r2 = pyFunc.execute(retInt).asInt();
            System.out.println(r2);
            System.out.println("second: " + watch.stop().elapsed(TimeUnit.MILLISECONDS));
        }

        context.close();

    }

    /**
     * guest访问host语言的数据对象
     */
    private static void accessJavaObj() {
        JavaBean bean = new JavaBean("jack zeng");
        Context context = Context.newBuilder(PYTHON).build();
        context.getBindings(PYTHON).putMember("bean", bean);
        context.eval(PYTHON, "print(bean.getName())");
        context.close();
    }

    /**
     * host语言访问guest定义的类和数据
     * @throws IOException
     */
    private static void accessGuestObj() throws IOException {
        String pyStr = Resources.toString(Resources.getResource("py_02.py"), Charsets.UTF_8);
        System.out.println(pyStr);

        Context context = Context.newBuilder(PYTHON)
                .allowAllAccess(true)
                .build();

        Source source = Source.create(PYTHON, pyStr);
        context.eval(source); // load and compile

        Value func = context.getPolyglotBindings().getMember("get_obj");
        Value obj = func.execute();
        if (obj.hasMembers()) {
            String name = obj.getMember("name").asString();
            int age = obj.getMember("age").isNull() ? -1 : obj.getMember("age").asInt();
            System.out.println("name: " + name + " age: " + age);
        }
        System.out.println("==========");

        Value value = context.eval(PYTHON, "PyObj()");
        System.out.println("has members: " + value.hasMembers());
        if (value.hasMembers()) {
            String name = value.getMember("name").asString();
            int age = value.getMember("age").isNull() ? -1 : value.getMember("age").asInt();
            System.out.println("name: " + name + " age: " + age);
        }

        context.close();
    }




}
