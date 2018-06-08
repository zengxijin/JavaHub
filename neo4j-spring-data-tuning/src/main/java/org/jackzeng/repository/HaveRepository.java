package org.jackzeng.repository;

import org.jackzeng.domain.rel.Have;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/6/8
 */
public interface HaveRepository extends Neo4jRepository<Have, Long> {
}
