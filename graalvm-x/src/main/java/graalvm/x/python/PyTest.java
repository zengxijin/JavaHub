package graalvm.x.python;

import org.graalvm.polyglot.Context;

/**
 * @author zengxijin created on 2019-11-22
 */
public class PyTest {

    public static void main(String[] args) {
        try (Context context = Context.create()) {
            context.eval("python", "print('Hi, Python!')");
        }
    }
}
