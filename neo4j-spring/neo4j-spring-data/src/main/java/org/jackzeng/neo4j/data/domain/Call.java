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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RelationshipEntity(type = "CALL")
public class Call<START extends BaseNodeEntity, END extends BaseNodeEntity> {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String callTime;

    @StartNode
    private START startNode;

    @EndNode
    private END endNode;
}
