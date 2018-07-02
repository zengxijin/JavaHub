package org.jackzeng.feign;

import com.bkjk.credit.approvalservice.api.CreditApprovalApi;
import com.bkjk.credit.approvalservice.data.request.quantgroup.CreditQueryRequest;
import com.bkjk.credit.approvalservice.data.request.quantgroup.CreditSubmitRequest;
import com.bkjk.credit.approvalservice.data.response.quantgroup.CreditQueryResponseBo;
import com.bkjk.credit.approvalservice.data.response.quantgroup.CreditSubmitResponseBo;
import com.bkjk.credit.datacollection.api.DataCollectionApi;
import com.bkjk.credit.datacollection.domain.FetchRelativeRecordRequestBo;
import com.bkjk.credit.datacollection.domain.FetchRelativeRecordResponseBo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author xijin.zeng created on 2018/5/14
 */
@Service
public class TestService {
    @Autowired
    private DataCollectionApi dataCollectionApi;

    @Autowired
    private CreditApprovalApi creditApprovalApi;

    public void test() {
        FetchRelativeRecordRequestBo fetchRelativeRecordRequestBo = new FetchRelativeRecordRequestBo();
        fetchRelativeRecordRequestBo.setCellphone("123");
        fetchRelativeRecordRequestBo.setName("abc");
        fetchRelativeRecordRequestBo.setSsn("190471298419846172");
        FetchRelativeRecordResponseBo responseBo = dataCollectionApi.fetchRelativeRecords("abc", fetchRelativeRecordRequestBo);
        System.out.println(responseBo);
    }

    public void testApprovalApi() throws IOException {
        String json ="{\n" +
                "       \"timestamp\": 1527245567466,               \n" +
                "\t\t\"name\":\"杨瑞平\",\n" +
                "\t\t\"ssn\":\"520221198403073011\",\n" +
                "\t    \"telephone\" : \"18216826522\",\n" +
                "\t    \"channelId\" : \"CREDIT_APPLICATION\",\n" +
                "\t    \"requestId\" : \"test_o04\",                   \n" +
                "    \t\"channelData\":{\n" +
                "\t        \"userId\" : \"test_o04\",\n" +
                "\t        \"bankcardType\" : \"debitcard\",\n" +
                "\t        \"bankcardNo\" : \"621785526620147001\",\n" +
                "\t        \"minBudget\" : 1000,\n" +
                "\t        \"maxBudget\" : 2000 ,\n" +
                "\t        \"isFreshGraduate\" : true,\n" +
                "\t        \"rentalCity\" : \"上海\",\n" +
                "\t        \"occupation\" : \" STUDENT \",\n" +
                "\t        \"school\" : \"上海交通大学1\",            \n" +
                "\t        \"graduationDate\": 1514764800001,              \n" +
                "\t        \"diplomaNo\" : \"1\",\n" +
                "\t        \"company\" : \"1\",\n" +
                "\t        \"jobPosition\" : \"高级开发工程师\",\n" +
                "\t        \"monthlySalary\" : 10001.0                \n" +
                "       }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();

        CreditSubmitRequest request = mapper.readValue(json, CreditSubmitRequest.class);
        System.out.println(request);

        CreditSubmitResponseBo response = creditApprovalApi.submitCreditRequest(request);
        System.out.println(mapper.writeValueAsString(response));

        String json2 = "{\n" +
                "\t\"name\": \"钱斌\",\n" +
                "    \"ssn\": \"469001199811128114\",\n" +
                "    \"telephone\": \"18621114725\",\n" +
                "\t\"timestamp\": 1527245567466,\n" +
                "\t\"channelId\": \"CREDIT_APPLICATION\",\n" +
                "\t\"requestId\": \"test_o04\",\n" +
                "\t\"channelData\": {\n" +
                "\t\t\"userId\": \"test_o04\"\n" +
                "\t}\n" +
                "}";

        CreditQueryRequest request2 = mapper.readValue(json2, CreditQueryRequest.class);
        CreditQueryResponseBo creditQueryResponseBo = creditApprovalApi.queryCreditResult(request2);
        System.out.println(mapper.writeValueAsString(creditQueryResponseBo));

    }
}
