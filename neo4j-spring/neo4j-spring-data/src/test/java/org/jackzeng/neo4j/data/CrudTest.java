package org.jackzeng.neo4j.data;

import org.jackzeng.neo4j.data.domain.Applicant;
import org.jackzeng.neo4j.data.domain.Company;
import org.jackzeng.neo4j.data.domain.Complaint;
import org.jackzeng.neo4j.data.domain.Loan;
import org.jackzeng.neo4j.data.repository.ApplicantRepository;
import org.jackzeng.neo4j.data.repository.CompanyRepository;
import org.jackzeng.neo4j.data.repository.ComplaintRepository;
import org.jackzeng.neo4j.data.repository.LoanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/4/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Test
    public void insertTest() {
        Loan loan = Loan.builder()
                .loanId("1234")
                .amount(new BigDecimal(123.123))
                .product("A")
                .build();

        Applicant applicant = Applicant.builder()
                .loans(Arrays.asList(loan))
                .name("张三")
                .phone("138123456789")
                .ssn("123456199910011234")
                .build();

        applicantRepository.save(applicant);

        Loan loan2 = Loan.builder()
                .loanId("5678")
                .amount(new BigDecimal(234.234))
                .product("B")
                .build();

        Applicant applicant2 = Applicant.builder()
                .loans(Arrays.asList(loan2))
                .name("李四")
                .phone("138987654321")
                .ssn("123456199910015678")
                .build();

        applicantRepository.save(applicant2);
    }

    @Test
    public void queryTest() throws Exception {
        Iterable<Map<String,Object>> it = loanRepository.queryByCypher(10);
        it.forEach(
                kv -> {
                    kv.entrySet().forEach(
                           item->{
                               System.out.println(item.getKey());
                               System.out.println(item.getValue());
                           }
                    );
                }
        );
    }

    @Test
    public void deleteTest() throws Exception {
        Loan loan = loanRepository.findByLoanId("1234");
        System.out.println(loan);

        Applicant applicant = applicantRepository.findBySsn("123456199910011234");
        System.out.println(applicant);

        if (loan != null) {
            loanRepository.delete(loan);
        }

        if (applicant != null) {
            applicantRepository.delete(applicant);
        }

        Loan loan2 = loanRepository.findByLoanId("5678");
        System.out.println(loan2);

        Applicant applicant2 = applicantRepository.findBySsn("123456199910015678");
        System.out.println(applicant2);

        if (loan2 != null) {
            loanRepository.delete(loan2);
        }

        if (applicant2 != null) {
            applicantRepository.delete(applicant2);
        }
    }

    @Autowired
    private ComplaintRepository complaintRepository;

    @Test
    public void testCompliant() throws Exception {
        Complaint complaint = complaintRepository.findById(1422680);
        System.out.println(complaint);
    }

    @Autowired
    private CompanyRepository companyRepository;
    @Test
    public void testCompany() throws Exception {
        Company company = companyRepository.findFirstByName("EXPERIAN INFORMATION SOLUTIONS INC.");
        System.out.println(company);
    }
}
