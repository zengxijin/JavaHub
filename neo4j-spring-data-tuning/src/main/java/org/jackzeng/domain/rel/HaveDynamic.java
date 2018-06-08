package org.jackzeng.domain.rel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jackzeng.constant.RelsType;
import org.jackzeng.domain.BaseNode;
import org.jackzeng.domain.BaseRel;
import org.neo4j.ogm.annotation.*;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@RelationshipEntity(type = RelsType.HAVE)
public class HaveDynamic<S extends BaseNode, E extends BaseNode> extends BaseRel {

    @Property
    private String createTime;

    @StartNode
    private S startNode;

    @EndNode
    private E endNode;
}
