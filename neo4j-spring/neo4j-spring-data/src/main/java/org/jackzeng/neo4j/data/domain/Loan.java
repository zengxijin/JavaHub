package org.jackzeng.neo4j.data.domain;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.jackzeng.neo4j.data.constant.RelationshipType;
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
public class Loan extends BaseNodeEntity {

    private String loanId;

    private BigDecimal amount;

    private String product;

    @ToStringExclude
    @HashCodeExclude
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
        return new ReflectionToStringBuilder(this)
                .setExcludeFieldNames("applicants")
                .toString();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    //    @Override
//    public String toString() {
//        return "Loan{" +
//                "id=" + id +
//                ", loanId='" + loanId + '\'' +
//                ", amount=" + amount +
//                ", product='" + product + '\'' +
//                ", applicants='" + applicantsToString() + '\'' +
//                '}';
//    }
//
//    private String applicantsToString() {
//        if (this.applicants == null) {
//            return "null";
//        }
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("[");
//        applicants.forEach(
//                app -> {
//                    builder.append("{");
//                    builder.append(" id='" + app.getId() + "',");
//                    builder.append(" ssn='" + app.getSsn() + "',");
//                    builder.append(" name='" + app.getName() + "',");
//                    builder.append(" phone='" + app.getPhone() + "'");
//                    builder.append("}");
//                    builder.append(",");
//                }
//        );
//        return builder.toString().substring(0,builder.toString().length()-1) + "]";
//    }
}
