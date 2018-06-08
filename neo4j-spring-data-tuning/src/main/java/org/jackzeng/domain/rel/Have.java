package org.jackzeng.domain.rel;

import lombok.Data;
import org.jackzeng.constant.RelsType;
import org.jackzeng.domain.node.Car;
import org.jackzeng.domain.node.Customer;
import org.neo4j.ogm.annotation.*;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@RelationshipEntity(type = RelsType.HAVE)
public class Have {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String createTime;

    @StartNode
    private Customer customer;
    @EndNode
    private Car car;
}
