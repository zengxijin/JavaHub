package org.jackzeng.neo4j.data.domain;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jackzeng.neo4j.data.constant.RelationshipType;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @author xijin.zeng created on 2018/4/24
 */
@NodeEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String ssn;

    private String phone;

    @Relationship(type = RelationshipType.APPLY, direction = Relationship.OUTGOING)
    private List<Loan> loans;

    public void addLoan(Loan loan) {
        if (loan != null) {
            if (this.loans == null) {
                this.loans = Lists.newArrayList();
            }
            loans.add(loan);
        }
    }
}
