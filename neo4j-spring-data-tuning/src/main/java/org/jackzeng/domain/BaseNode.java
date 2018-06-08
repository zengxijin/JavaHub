package org.jackzeng.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * @author xijin.zeng created on 2018/6/8
 */

/**
 * 基础节点类型
 */
@Data
public class BaseNode {
    @Id
    @GeneratedValue
    private Long id;
}
