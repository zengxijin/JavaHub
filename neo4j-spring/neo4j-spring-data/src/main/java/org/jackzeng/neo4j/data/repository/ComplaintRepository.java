package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Complaint;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author xijin.zeng created on 2018/4/25
 */
public interface ComplaintRepository extends Neo4jRepository<Complaint, Long> {
    Complaint findById(@Param("id") int id);
}
