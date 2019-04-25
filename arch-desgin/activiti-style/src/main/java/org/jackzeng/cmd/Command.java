package org.jackzeng.cmd;

/**
 * @author xijin.zeng created on 2018/11/15
 */
public interface Command<T> {

    T execute(CommandContext commandContext);

}
