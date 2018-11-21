package org.jackzeng.cmd;

import lombok.Getter;
import lombok.Setter;
import org.jackzeng.cfg.EngineConfiguration;

import java.util.Objects;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public class CommandContextInterceptor extends AbstractCommandInterceptor {

    @Getter @Setter
    protected EngineConfiguration engineConfiguration;
    @Getter @Setter
    protected CommandContextFactory commandContextFactory;

    public CommandContextInterceptor(EngineConfiguration engineConfiguration, CommandContextFactory commandContextFactory) {
        this.engineConfiguration = engineConfiguration;
        this.commandContextFactory = commandContextFactory;
    }

    @Override
    public <T> T execute(Command<T> command, CommandConfiguration configuration) {
        CommandContext commandContext = Context.getCommandContext();

        boolean isContextReuse = false;

        if (!configuration.isCommandContextReuse() || Objects.isNull(commandContext) || Objects.nonNull(commandContext.getException())) {
            commandContext = commandContextFactory.createCommandContext(command);
        } else {
            isContextReuse = true;
        }

        try {
            Context.setCommandContext(commandContext);
            Context.setEngineConfiguration(engineConfiguration);

            return next.execute(command, configuration);

        } catch (Exception ex) {
            commandContext.handleException();
        } finally {
            try {
                if (!isContextReuse) {
                    commandContext.close();
                }
            } finally {
                Context.removeCommandContext();
                Context.removeEngineConfiguration();
            }
        }

        //should not go here
        return null;
    }
}
