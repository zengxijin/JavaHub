package org.jackzeng.cmd;

import org.jackzeng.cfg.EngineConfiguration;

import java.util.Objects;
import java.util.Stack;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public final class Context {

    protected static ThreadLocal<Stack<CommandContext>> commandContextThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Stack<EngineConfiguration>> engineConfigurationThreadLocal = new ThreadLocal<>();

    public static CommandContext getCommandContext() {
        Stack<CommandContext> stack = getStack(commandContextThreadLocal);

        return stack.isEmpty() ? null : stack.peek();
    }

    public static void setCommandContext(CommandContext commandContext) {
        getStack(commandContextThreadLocal).push(commandContext);
    }

    public static void removeCommandContext() {
        getStack(commandContextThreadLocal).pop();
    }

    public static EngineConfiguration getEngineConfiguration() {
        Stack<EngineConfiguration> stack = getStack(engineConfigurationThreadLocal);
        return stack.isEmpty() ? null : stack.peek();
    }

    public static void setEngineConfiguration(EngineConfiguration engineConfiguration) {
        getStack(engineConfigurationThreadLocal).push(engineConfiguration);
    }

    public static void removeEngineConfiguration() {
        getStack(engineConfigurationThreadLocal).pop();
    }

    protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> stackThreadLocal) {
        Stack<T> stack = stackThreadLocal.get();
        if (Objects.isNull(stack)) {
            stack = new Stack<T>();
            stackThreadLocal.set(stack);
        }

        return stack;
    }
}
