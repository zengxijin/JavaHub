package org.jackzeng.engine;

import lombok.Getter;
import org.jackzeng.cfg.EngineConfiguration;
import org.jackzeng.engine.service.RuntimeService;

/**
 * @author xijin.zeng created on 2018/11/21
 */
public class RuleEngineImpl implements RuleEngine {

    private RuntimeService runtimeService;
    private EngineConfiguration engineConfiguration;

    public RuleEngineImpl(EngineConfiguration engineConfiguration) {
        this.engineConfiguration = engineConfiguration;

        this.runtimeService = engineConfiguration.getRuntimeService();
    }

    @Override
    public RuntimeService getRuntimeService() {
        return this.runtimeService;
    }

    @Override
    public EngineConfiguration getEngineConfiguration() {
        return this.engineConfiguration;
    }
}
