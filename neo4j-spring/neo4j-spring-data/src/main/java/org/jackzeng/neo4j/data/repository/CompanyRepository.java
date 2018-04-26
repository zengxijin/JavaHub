package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author xijin.zeng created on 2018/4/25
 */
public interface CompanyRepository extends Neo4jRepository<Company, Long> {
    Company findFirstByName(@Param("name") String name);
}
