package org.jackzeng.kie.cfg;

/**
 * 配置封装使用kie-server调用原生REST的一下关键操作和参数
 * @ClassName: KieServiceRawCmd
 * @Author:  XijinZeng 
 * @CreateDate: [2017-3-22 10:46:44]   
 */

public class KieServiceRawCmd {
	//common cmd
	public static final String LOOKUP        = "lookup";
	public static final String COMMANDS      = "commands";
	
	//action cmd
	public static final String INSERT         = "insert";
	public static final String QUERY          = "query";
	public static final String START_PROCESS  = "start-process";
	public static final String FIRE_ALL_RULES = "fire-all-rules";
	public static final String GET_OBJECTS    = "get-objects";
	
	//action params
	public static final String RETURN_OBJECT  = "return-object"; //true or false
	public static final String OUT_IDENTIFIER = "out-identifier";
	public static final String PROCESS_ID     = "processId";     //for start-process
	public static final String NAME           = "name";          //for query
}
