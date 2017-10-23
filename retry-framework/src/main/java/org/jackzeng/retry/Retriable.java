package org.jackzeng.retry;

/**
 * @author zengxijin created on 2017/8/22
 */
public interface Retriable<T extends RetryResult> {
    T retry();
    default void beforeRetry(){}
    default void postRetry(){}
}
