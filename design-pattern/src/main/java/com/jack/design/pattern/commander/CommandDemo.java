package com.jack.design.pattern.commander;

public class CommandDemo {

	public static void main(String[] args) {
		
		RuntimeServiceCommand runtimeServiceCommand = new  RuntimeServiceCommandImpl();
		
		Command complete = new CompleteCommand(runtimeServiceCommand);
		Command start = new StartCommand(runtimeServiceCommand);
		
		BatchCommandExecutor executor = new BatchCommandExecutor();
		executor.addCmd(complete);
		executor.addCmd(start);
		
		executor.executeCmds();
	}

}
