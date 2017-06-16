package org.jackzeng.kie;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.Arrays;

/**
 * Created by XijinZeng on 2017/6/15.
 */
public class JSONRest {
    private static final MarshallingFormat FORMAT =  MarshallingFormat.JSON;

    private KieServicesConfiguration conf;
    private KieServicesClient kieServicesClient;

    public JSONRest(KieServerCfg serverCfg){
        initialize(serverCfg);
    }

    public void initialize(KieServerCfg serverCfg) {
        conf = KieServicesFactory.newRestConfiguration(serverCfg.getUrl(), serverCfg.getUser(), serverCfg.getPassword());
        conf.setMarshallingFormat(FORMAT);
        kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
    }

    public String executeCmds(String containerId, Object insertObject){
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);
        KieCommands commands = KieServices.Factory.get().getCommands();

        Command<?> insertCmd    = commands.newInsert(insertObject);
        Command<?> fireAllRules = commands.newFireAllRules();
        Command<?> batchCmds    = commands.newBatchExecution(Arrays.asList(insertCmd, fireAllRules));

        ServiceResponse<String> response = ruleServicesClient.executeCommands(containerId, batchCmds);

        if(response.getType() == ServiceResponse.ResponseType.SUCCESS){
            return response.getResult();
        }

        return response.getMsg();
    }
}
