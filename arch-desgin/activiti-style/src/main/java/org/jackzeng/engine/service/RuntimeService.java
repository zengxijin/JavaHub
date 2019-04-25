package org.jackzeng.engine.service;

import java.util.Map;

/**
 * 基于引擎内核的某一类型的服务
 *
 * @author xijin.zeng created on 2018/11/15
 */
public interface RuntimeService {

    Map<String, Object> getVariables(String executionId);

    Object getVariable(String executionId, String variableName);
}
