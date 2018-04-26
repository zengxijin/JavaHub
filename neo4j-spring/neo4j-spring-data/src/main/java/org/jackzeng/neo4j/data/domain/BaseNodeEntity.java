package org.jackzeng.neo4j.data.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author xijin.zeng created on 2018/4/25
 */
@NodeEntity
public abstract class BaseNodeEntity {
    @Id
    @GeneratedValue
    private Long id;
}
