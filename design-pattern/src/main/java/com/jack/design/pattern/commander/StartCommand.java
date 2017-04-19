package com.jack.design.pattern.commander;

public class StartCommand implements Command {
	
	private RuntimeServiceCommand runtimeServiceCommand; 

	@Override
	public void execute() {
		runtimeServiceCommand.start();
	}
	
	public StartCommand(RuntimeServiceCommand runtimeServiceCommand){
		this.runtimeServiceCommand = runtimeServiceCommand;
	}

}
