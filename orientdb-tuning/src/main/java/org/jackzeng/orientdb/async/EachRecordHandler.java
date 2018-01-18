package org.jackzeng.orientdb.async;

/**
 * @author zengxj
 * @create 2018/1/18
 */
@FunctionalInterface
public interface EachRecordHandler {
    boolean each(Object iRecord);
}
