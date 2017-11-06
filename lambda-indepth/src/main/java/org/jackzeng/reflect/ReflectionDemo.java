package org.jackzeng.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zengxj
 * @create 2017/11/6
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        ReflectionDemo demo = new ReflectionDemo();
        try {
            int M, N;
            M = N = 100000;

            long start = System.currentTimeMillis();
            while (M-- > 0) {
                demo.instanceMethodTest();
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("total time(ms):" + time);

            long start2 = System.currentTimeMillis();
            while (N-- > 0) {
                demo.staticMethodTest();
            }
            long end2 = System.currentTimeMillis();
            long time2 = end2 - start2;
            System.out.println("total time(ms):" + time2);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void instanceMethodTest() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {

        /**
         * get the Class
         * (1) XXX.class
         * (2) Class.forName(xxx.xxx.XXX)
         * ...
         */
        Class instanceCls = Class.forName("org.jackzeng.reflect.InstanceMethodDemo");
        // instanceCls.getDeclaredMethod("dummyMethodV2", Integer.class, Integer.class) not working
        Method v1 = instanceCls.getDeclaredMethod("dummyMethodV1", int.class, int.class);
        Method v2 = instanceCls.getDeclaredMethod("dummyMethodV2", int.class, int.class);

        Object instance = instanceCls.newInstance();
        Integer result = (Integer) v1.invoke(instance,1,2);
        Integer result2 = (Integer) v2.invoke(instance,1,2);

        //System.out.println(result);
        //System.out.println(result2);
    }

    public void staticMethodTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class instanceCls = Class.forName("org.jackzeng.reflect.StaticMethodDemo");
        Method v1 = instanceCls.getDeclaredMethod("dummyMethodV1", int.class, int.class);
        Method v2 = instanceCls.getDeclaredMethod("dummyMethodV2", int.class, int.class);
        Integer result = (Integer) v1.invoke(null,1,2);
        Integer result2 = (Integer) v2.invoke(null,1,2);
    }


}
