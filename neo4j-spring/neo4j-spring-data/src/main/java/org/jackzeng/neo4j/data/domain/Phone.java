package org.jackzeng.neo4j.data.domain;

import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author xijin.zeng created on 2018/5/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@NodeEntity
public class Phone extends BaseNodeEntity{

    private String phoneNo;
}
