package org.jackzeng.cmd;

import lombok.Getter;

/**
 * @author xijin.zeng created on 2018/11/15
 */
public class CommandExecutorImpl implements CommandExecutor {

    @Getter
    private final CommandConfiguration defaultConfig;

    @Getter
    private final CommandInterceptor first;

    public CommandExecutorImpl(CommandConfiguration defaultConfig, CommandInterceptor first) {
        this.defaultConfig = defaultConfig;
        this.first = first;
    }

    /**
     * Command执行入口
     * @param command
     * @param <T>
     * @return
     */
    @Override
    public <T> T execute(Command<T> command) {
        return this.execute(command, this.defaultConfig);
    }

    public <T> T execute(Command<T> command, CommandConfiguration commandConfiguration) {
        return first.execute(command, commandConfiguration);
    }
}
