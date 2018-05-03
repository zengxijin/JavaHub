package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Own;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/5/3
 */
public interface OwnRepository extends Neo4jRepository<Own, Long> {
    Own findByPro(String pro);
}
