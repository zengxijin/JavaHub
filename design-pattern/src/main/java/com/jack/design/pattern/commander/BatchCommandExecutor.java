package com.jack.design.pattern.commander;

import java.util.ArrayList;
import java.util.List;

public class BatchCommandExecutor {
	private List<Command> cmds;
	
	public BatchCommandExecutor(List<Command> cmds){
		this.cmds = cmds;
	}
	
	public BatchCommandExecutor(){
		this.cmds = new ArrayList<Command>();
	}
	
	public void addCmd(Command cmd){
		if(cmds == null){
			cmds = new ArrayList<Command>();
		}
		
		cmds.add(cmd);
	}
	
	public void executeCmds(){
		for(Command cmd : cmds){
			cmd.execute();
		}
		cmds.clear();
	}
}
