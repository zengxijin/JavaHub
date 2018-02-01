package org.jackzeng.rxjava;

import io.reactivex.Flowable;

/**
 * @author zengxj
 * @create 2018/1/29
 */
public class DummySample {
    public static void main(String[] args) {

    }

    public static void justTest() {
        Flowable.just("DummySample").subscribe(txt -> System.out.println(txt));
    }
}
