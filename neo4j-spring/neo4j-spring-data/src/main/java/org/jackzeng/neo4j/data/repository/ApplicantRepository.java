package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Applicant;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * @author xijin.zeng created on 2018/4/24
 */
public interface ApplicantRepository extends Neo4jRepository<Applicant, Long> {

    Applicant findBySsn(@Param("ssn") String ssn);

    Collection<Applicant> findByNameLike(@Param("name") String name);

}
