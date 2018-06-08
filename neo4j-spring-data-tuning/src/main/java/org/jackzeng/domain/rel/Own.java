package org.jackzeng.domain.rel;

import lombok.Data;
import org.jackzeng.constant.RelsType;
import org.jackzeng.domain.node.Phone;
import org.jackzeng.domain.node.User;
import org.neo4j.ogm.annotation.*;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@RelationshipEntity(type = RelsType.OWN)
public class Own {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String createTime;

    @StartNode
    private User user;

    @EndNode
    private Phone phone;
}
