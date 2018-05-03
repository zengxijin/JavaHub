package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Applicant;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/4/24
 */
public interface ApplicantRepository extends Neo4jRepository<Applicant, Long> {

    Applicant findBySsn(@Param("ssn") String ssn);

    Collection<Applicant> findByNameLike(@Param("name") String name);

    @Query("MATCH (app:Applicant)-[r:APPLY]->(loan:Loan) return loan,r,app LIMIT {limit}")
    Iterable<Map<String, Object>> queryByCypher(@Param("limit") int limit);
}
