package org.jackzeng.neo4j.data.repository;

import org.jackzeng.neo4j.data.constant.LoanStatus;
import org.jackzeng.neo4j.data.constant.SingleFieldEnum;
import org.jackzeng.neo4j.data.domain.EnumTestNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author xijin.zeng created on 2018/5/10
 */
public interface EnumTestNodeRepository extends Neo4jRepository<EnumTestNode, Long> {
    EnumTestNode findFirstByLoanStatus(LoanStatus loanStatus);

    EnumTestNode findFirstBySingleFieldEnum(SingleFieldEnum singleFieldEnum);
}
