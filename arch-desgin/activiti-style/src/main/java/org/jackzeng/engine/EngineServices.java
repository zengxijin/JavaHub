package org.jackzeng.engine;

import org.jackzeng.cfg.EngineConfiguration;
import org.jackzeng.engine.service.RuntimeService;

/**
 * Facade门面设计模式，提供引擎的核心API服务
 *
 * @author xijin.zeng created on 2018/11/15
 */
public interface EngineServices {

    RuntimeService getRuntimeService();

    EngineConfiguration getEngineConfiguration();
}
