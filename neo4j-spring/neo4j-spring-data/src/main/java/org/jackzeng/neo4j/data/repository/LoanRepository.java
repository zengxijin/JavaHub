package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.domain.Loan;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * @author xijin.zeng created on 2018/4/24
 */
public interface LoanRepository extends Neo4jRepository<Loan, Long> {

    Loan findByLoanId(@Param("loanId") String loanId);

    Collection<Loan> findAllByProduct(@Param("product") String product);

    @Query("MATCH (loan:Loan)<-[r:APPLY]-(app:Applicant) return loan,r,app LIMIT {limit}")
    Collection<Loan> queryByCypher(@Param("limit") int limit);

}
