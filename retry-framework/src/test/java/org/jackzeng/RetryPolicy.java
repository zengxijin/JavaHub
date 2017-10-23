package org.jackzeng;

/**
 * @author zengxijin created on 2017/8/24
 */
public class RetryPolicy {
    private String name;
    private int priority;

    public RetryPolicy(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "RetryPolicy{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
