package org.jackzeng.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author zengxj
 * @create 2017/11/6
 */
public class MethodHandlesDemo {

    public static void hi() {
        System.out.println("hi");
    }

    public void hi2() {
        System.out.println("hi2");
    }

    public int dummyMethodV1(int a, int b) {
        return (a + b);
    }

    public int dummyMethodV2(int a, int b) {
        return (a + b) * 2;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        //static method
        MethodHandle hi = lookup.findStatic(MethodHandlesDemo.class, "hi", MethodType.methodType(void.class));
        hi.invokeExact();

        //instance method
        MethodHandlesDemo demo = new MethodHandlesDemo();
        MethodHandle hi2 = lookup.findVirtual(MethodHandlesDemo.class, "hi2", MethodType.methodType(void.class));
        hi2.invokeExact(demo);


//        MethodHandle dummyMethodV1 = lookup.findVirtual(MethodHandlesDemo.class, "dummyMethodV1",
//                MethodType.methodType(int.class,int.class,int.class));
//        dummyMethodV1.invokeExact(MethodHandlesDemo.class.newInstance(),1,2);


        int M = 100000;

        long start = System.currentTimeMillis();

        while (M-- > 0) {
            MethodHandle handle = demo.methodHandleTest();
            int x = (int)handle.invokeExact(MethodHandlesDemo.class.newInstance(),1,2);
        }
        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("total time(ms):" + time);

    }

    public MethodHandle methodHandleTest() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle dummyMethodV1 = lookup.findVirtual(MethodHandlesDemo.class, "dummyMethodV1",
                MethodType.methodType(int.class,int.class,int.class));
        return dummyMethodV1;
        //dummyMethodV1.invokeExact(MethodHandlesDemo.class.newInstance(),1,2);
    }



}
