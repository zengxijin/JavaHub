package org.jackzeng.neo4j.data.domain.rel;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author xijin.zeng created on 2018/5/21
 */
@Data
public class BaseRel {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime createTime = LocalDateTime.now();
}
