package org.jackzeng.neo4j.data;

import org.jackzeng.neo4j.data.constant.LoanStatus;
import org.jackzeng.neo4j.data.constant.SingleFieldEnum;
import org.jackzeng.neo4j.data.domain.EnumTestNode;
import org.jackzeng.neo4j.data.repository.EnumTestNodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author xijin.zeng created on 2018/5/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumTest {

    @Autowired
    private EnumTestNodeRepository enumTestNodeRepository;

    @Test
    public void saveTest() throws Exception {
        EnumTestNode enumTestNode = EnumTestNode.builder()
                .singleFieldEnum(SingleFieldEnum.ONE) //测试结果显示只会保存字符串字面量ONE，不会保存对应里面的enum中的值
                .loanStatus(LoanStatus.NORMAL) //测试结果显示只会保存字符串字面量NORMAL
                .stringPro("stringVAL")
                .build();

        EnumTestNode savedNode = enumTestNodeRepository.save(enumTestNode);
        System.out.println(savedNode.getId());
    }

    //MATCH (n:`EnumTestNode`) WHERE ID(n) = { id } WITH n RETURN n with params {id=8}
    @Test
    public void queryTestById() throws Exception {
        Optional<EnumTestNode> node = enumTestNodeRepository.findById(8L);
        System.out.println(node.get().getLoanStatus());
    }

    //MATCH (n:`EnumTestNode`) WHERE n.`loanStatus` = { `loanStatus_0` } WITH n RETURN n, ID(n) with params {loanStatus_0=NORMAL} EnumTestNode(id=8, loanStatus=NORMAL, singleFieldEnum=ONE, stringPro=stringVAL)
    @Test
    public void queryByEnumField() throws Exception {
        EnumTestNode node = enumTestNodeRepository.findFirstByLoanStatus(LoanStatus.NORMAL);
        System.out.println(node);
    }

    //MATCH (n:`EnumTestNode`) WHERE n.`singleFieldEnum` = { `singleFieldEnum_0` } WITH n RETURN n, ID(n) with params {singleFieldEnum_0=ONE}
    @Test
    public void queryByEnumField2() throws Exception {
        EnumTestNode node = enumTestNodeRepository.findFirstBySingleFieldEnum(SingleFieldEnum.ONE);
        System.out.println(node);
    }
}
