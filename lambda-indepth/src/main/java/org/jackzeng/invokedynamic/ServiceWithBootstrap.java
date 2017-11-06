package org.jackzeng.invokedynamic;

import java.lang.invoke.*;

/**
 * @author zengxj
 * @create 2017/11/6
 */
public class ServiceWithBootstrap {

    public static void hello() {
        System.out.println("Hello");
    }

    public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class thisClass = lookup.lookupClass();
        MethodHandle mh = lookup.findStatic(thisClass, "hello", MethodType.methodType(void.class));

        System.out.println(caller.getClass().getTypeName());
        System.out.println(name);

        return new ConstantCallSite(mh.asType(type));
    }
}

