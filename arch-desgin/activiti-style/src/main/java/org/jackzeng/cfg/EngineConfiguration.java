package org.jackzeng.cfg;

import lombok.Getter;
import org.jackzeng.engine.RuleEngine;
import org.jackzeng.engine.RuleEngineImpl;
import org.jackzeng.engine.service.RuntimeService;
import org.jackzeng.engine.service.impl.RuntimeServiceImpl;

/**
 * 引擎的配置: 需要初始化
 * 高级或额外的配置
 *
 * @author xijin.zeng created on 2018/11/15
 */
public class EngineConfiguration extends AbstractEngineConfiguration {

    @Getter
    protected RuntimeService runtimeService = new RuntimeServiceImpl();

    protected void init() {
        //TODO: init other resources here
    }

    public RuleEngine buildEngine() {
        this.init();

        return new RuleEngineImpl(this);
    }
}
