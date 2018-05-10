package org.jackzeng.neo4j.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jackzeng.neo4j.data.constant.LoanStatus;
import org.jackzeng.neo4j.data.constant.SingleFieldEnum;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author xijin.zeng created on 2018/5/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class EnumTestNode {

    @Id
    @GeneratedValue
    private Long id;

    private LoanStatus loanStatus;
    private SingleFieldEnum singleFieldEnum;
    private String stringPro;
}
