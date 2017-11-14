package org.jackzeng.truck;

import java.util.function.Function;

/**
 * @author zengxj
 * @create 2017/11/14
 */
public class LambdaTest {

    private final Function<String, Boolean> func = createAgent()::invokeFunc;

    private String simpleField;

    //尽管在构造函数对simpleField进行了初始化
    public LambdaTest() {
        System.out.println("construct");
        simpleField = "123";
    }

    private Agent createAgent() {
        return new Agent(this.simpleField);
    }

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
    }

    class Agent {
        private final Function<String, Boolean> func;

        public boolean invokeFunc(String task) {
            return func.apply(task);
        }

        public Agent(String task) {
            System.out.println(task);
            func = getFunc();
        }

        private Function<String, Boolean> getFunc() {
            return task -> {
                System.out.println(task);
                return true;
            };
        }
    }
}
