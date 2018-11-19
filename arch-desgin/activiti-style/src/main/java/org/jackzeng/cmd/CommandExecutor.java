package org.jackzeng.cmd;

/**
 * @author xijin.zeng created on 2018/11/15
 */
public interface CommandExecutor {

    <T> T execute(Command<T> command);

}
