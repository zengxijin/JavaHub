package org.jackzeng.domain.node;

import lombok.Data;
import org.jackzeng.constant.RelsType;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@NodeEntity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * 一对多的关系
     */
    @Relationship(type = RelsType.OWN, direction = Relationship.OUTGOING)
    private List<Phone> phones;
}
