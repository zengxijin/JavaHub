package org.jackzeng.cmd;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public interface CommandInterceptor {

    <T> T execute(Command<T> command, CommandConfiguration configuration);

    CommandInterceptor getNext();

    void setNext(CommandInterceptor next);
}
