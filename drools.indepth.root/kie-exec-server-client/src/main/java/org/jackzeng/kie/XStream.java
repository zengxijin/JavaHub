package org.jackzeng.kie;

import org.drools.core.command.impl.GenericCommand;
import org.drools.core.command.runtime.BatchExecutionCommandImpl;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.internal.runtime.helper.BatchExecutionHelper;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XijinZeng on 2017/6/14.
 */
public class XStream {

    public String xstreamParams(List<Object> objects){
        String ret = null;

        List<GenericCommand<?>> cmds = new ArrayList<GenericCommand<?>>();

        for (Object object : objects){
            InsertObjectCommand cmd = new InsertObjectCommand(object);
            cmd.setReturnObject(true);
            cmds.add(cmd);
        }

        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();
        cmds.add(fireAllRulesCommand);

        BatchExecutionCommand batchExecutionCommand = new BatchExecutionCommandImpl(cmds);

        ret = BatchExecutionHelper.newXStreamMarshaller().toXML(batchExecutionCommand);

        return ret;
    }

    public String execute(KieServerCfg serverCfg, String container, String payload){

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                serverCfg.getUrl(),
                serverCfg.getUser(),
                serverCfg.getPassword()
        );



        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        //RuleServicesClient ruleServicesClient = client.getServicesClient(RuleServicesClient.class);

        ServiceResponse<String> response = client.executeCommands(container, payload);
        if(response.getType() == ServiceResponse.ResponseType.SUCCESS){
            return response.getResult();
        }

        return response.getMsg();
    }

}
