package org.jackzeng.cmd;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public abstract class AbstractCommandInterceptor implements CommandInterceptor {

    protected CommandInterceptor next;

    @Override
    public CommandInterceptor getNext() {
        return next;
    }

    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }
}
