package org.jackzeng.neo4j.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * @author xijin.zeng created on 2018/5/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RelationshipEntity(type = "OWN")
public class Own {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String pro;

    @StartNode
    private Person person;

    @EndNode
    private Phone phone;

}
