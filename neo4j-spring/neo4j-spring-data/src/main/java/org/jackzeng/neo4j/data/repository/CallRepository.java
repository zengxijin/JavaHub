package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Call;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/5/3
 */
public interface CallRepository extends Neo4jRepository<Call, Long> {
}
