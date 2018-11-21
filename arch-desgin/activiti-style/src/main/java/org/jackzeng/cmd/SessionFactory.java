package org.jackzeng.cmd;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public interface SessionFactory {

    Class<?> getSessionType();

    Session openSession();
}
