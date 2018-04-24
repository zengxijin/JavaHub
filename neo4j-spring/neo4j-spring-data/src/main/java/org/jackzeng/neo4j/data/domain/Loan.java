package org.jackzeng.neo4j.data.domain;

import com.google.common.collect.Lists;
import lombok.*;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.jackzeng.neo4j.data.constant.RelationshipType;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xijin.zeng created on 2018/4/24
 */
@NodeEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue
    private Long id;

    private String loanId;

    private BigDecimal amount;

    private String product;

    @Relationship(type = RelationshipType.APPLY, direction = Relationship.INCOMING)
    private List<Applicant> applicants;

    public void addApplicant(Applicant applicant) {
        if (applicant != null) {
            if (this.applicants == null) {
                this.applicants = Lists.newArrayList();
            }

            this.applicants.add(applicant);
        }
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanId='" + loanId + '\'' +
                ", amount=" + amount +
                ", product='" + product + '\'' +
                ", applicants='" + applicantsToString() + '\'' +
                '}';
    }

    private String applicantsToString() {
        if (this.applicants == null) {
            return "null";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        applicants.forEach(
                app -> {
                    builder.append("{");
                    builder.append("ssn=" + app.getSsn());
                    builder.append("}");
                    builder.append(",");
                }
        );
        return builder.toString().substring(0,builder.toString().length()-1) + "]";
    }
}
