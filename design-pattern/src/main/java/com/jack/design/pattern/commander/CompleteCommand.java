package com.jack.design.pattern.commander;

public class CompleteCommand implements Command {
	
	private RuntimeServiceCommand runtimeServiceCommand; 

	@Override
	public void execute() {
		runtimeServiceCommand.complete();
	}
	
	public CompleteCommand(RuntimeServiceCommand runtimeServiceCommand){
		this.runtimeServiceCommand = runtimeServiceCommand;
	}

}
