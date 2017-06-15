package com.qf;

/**
 * Created by XijinZeng on 2017/6/14.
 */
public class MyBean implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    private java.lang.String name;
    private int age;

    public MyBean()
    {
    }

    public java.lang.String getName()
    {
        return this.name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public MyBean(java.lang.String name, int age)
    {
        this.name = name;
        this.age = age;
    }

}