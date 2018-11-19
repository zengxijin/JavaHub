package org.jackzeng.cmd;

import lombok.Getter;
import org.jackzeng.cfg.EngineConfiguration;

/**
 * 命令执行的上下文，Command执行时从CommandContext获取上下文
 *
 * @author xijin.zeng created on 2018/11/15
 */
public class CommandContext {

    @Getter
    protected Command<?> command;

    @Getter
    protected EngineConfiguration engineConfiguration;

    public CommandContext(Command<?> command, EngineConfiguration engineConfiguration) {
        this.command = command;
        this.engineConfiguration = engineConfiguration;
    }
}
