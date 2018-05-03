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

import java.util.List;

/**
 * @author xijin.zeng created on 2018/4/24
 */
@NodeEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Applicant extends BaseNodeEntity {

    private String name;

    private String ssn;

    private String phone;

    @ToStringExclude
    @HashCodeExclude
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

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).setExcludeFieldNames("loans").toString();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

//    @Override
//    public String toString() {
//        return "Applicant{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", ssn='" + ssn + '\'' +
//                ", phone='" + phone + '\'' +
//                ", loans='" + loansToString() + '\'' +
//                '}';
//    }
//
//    /**
//     * avoid recursive reference toString() StackOverflow problem
//     * @return
//     */
//    private String loansToString() {
//        if (this.loans == null) {
//            return "null";
//        }
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("[");
//        loans.forEach(
//                loan -> {
//                    builder.append("{");
//                    builder.append(" id='" + loan.getId() + "',");
//                    builder.append(" amount=" + loan.getAmount() + ",");
//                    builder.append(" product='" + loan.getProduct() + "',");
//                    builder.append(" loanId='" + loan.getLoanId() + "'");
//                    builder.append("}");
//                    builder.append(",");
//                }
//        );
//        return builder.toString().substring(0,builder.toString().length()-1) + "]";
//    }
}
