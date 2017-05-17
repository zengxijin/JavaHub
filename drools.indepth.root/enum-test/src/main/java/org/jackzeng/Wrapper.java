package org.jackzeng;

/**
 * Created by XijinZeng on 2017/5/11.
 */
public class Wrapper {

    public HelloEnum getHello() {
        return hello;
    }

    public void setHello(HelloEnum hello) {
        this.hello = hello;
    }

    private HelloEnum hello;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
