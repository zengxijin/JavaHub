package org.jackzeng.neo4j.data.domain.rel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jackzeng.neo4j.data.domain.BaseNodeEntity;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;

import java.util.Objects;

/**
 * @author xijin.zeng created on 2018/5/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DynamicRel<S extends BaseNodeEntity, E extends BaseNodeEntity> extends BaseRel {

    @StartNode
    private S startNode;

    @EndNode
    private E endNode;

    public DynamicRel buildRel(S startNode, E endNode) {
        Objects.requireNonNull(startNode);
        Objects.requireNonNull(endNode);

        this.startNode = startNode;
        this.endNode = endNode;

        return this;
    }
}
