package org.jackzeng.cmd;

import lombok.Getter;
import lombok.Setter;
import org.jackzeng.cfg.EngineConfiguration;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public class CommandContextFactory {

    @Getter
    @Setter
    protected EngineConfiguration engineConfiguration;

    public CommandContext createCommandContext(Command<?> command) {
        return new CommandContext(command, engineConfiguration);
    }
}
