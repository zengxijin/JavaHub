package org.jackzeng.repository;

import org.jackzeng.domain.rel.HaveDynamic;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/6/8
 */
public interface HaveDynamicRepository extends Neo4jRepository<HaveDynamic, Long> {
}
