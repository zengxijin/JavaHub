package org.jackzeng.cmd;

import lombok.Getter;
import org.jackzeng.cfg.EngineConfiguration;
import org.jackzeng.manager.ManagerFactory;

/**
 * 命令执行的上下文，Command执行时从CommandContext获取上下文
 *
 * @author xijin.zeng created on 2018/11/15
 */
public class CommandContext {

    @Getter
    protected Command<?> command;

    @Getter
    protected ManagerFactory managerFactory;

    @Getter
    protected Throwable exception;

    @Getter
    protected EngineConfiguration engineConfiguration;

    public CommandContext(Command<?> command, EngineConfiguration engineConfiguration) {
        this.command = command;
        this.engineConfiguration = engineConfiguration;

        this.managerFactory = new ManagerFactory();
    }

    public void close() {
        //TODO:add impl
    }

    public void handleException() {
        //TODO:add impl
    }
}
