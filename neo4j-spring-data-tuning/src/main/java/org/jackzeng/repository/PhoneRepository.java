package org.jackzeng.repository;

import org.jackzeng.domain.node.Phone;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/6/8
 */
public interface PhoneRepository extends Neo4jRepository<Phone, Long> {
}
