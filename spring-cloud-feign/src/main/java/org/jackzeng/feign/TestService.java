package org.jackzeng.feign;

import com.bkjk.credit.approvalservice.api.CreditApprovalApi;
import com.bkjk.credit.approvalservice.data.request.quantgroup.CreditSubmitRequest;
import com.bkjk.credit.approvalservice.data.response.quantgroup.CreditSubmitResponse;
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
        String json = "{\n" +
                "\t\"ssn\": \"310108199003208492\",\n" +
                "\t\"name\": \"王丽\",\n" +
                "\t\"telephone\": \"13810001000\",\n" +
                "\t\"channelId\": \"CREDIT_APPLICATION\",\n" +
                "\t\"requestId\": \"15\",\n" +
                "\t\"timestamp\": " + System.currentTimeMillis() + ",\n" +
                "\t\"channelData\": {\n" +
                "\t\t\"userId\": \"string4545447\",\n" +
                "\t\t\"bankcardType\": \"debitcard\",\n" +
                "\t\t\"bankcardNo\": \"6222000002204995655\",\n" +
                "\t\t\"minBudget\": 3000.0,\n" +
                "\t\t\"maxBudget\": 6000.0,\n" +
                "\t\t\"isFreshGraduate\": true,\n" +
                "\t\t\"rentalCity\": \"上海\",\n" +
                "\t\t\"occupation\": \"STUDENT\",\n" +
                "\t\t\"school\": \"上海交通大学\",\n" +
                "\t\t\"graduationDate\": 1526295138025,\n" +
                "\t\t\"diplomaNo\": \"string\",\n" +
                "\t\t\"company\": \"string\",\n" +
                "\t\t\"jobPosition\": \"高级开发工程师\",\n" +
                "\t\t\"monthlySalary\": 10000.0\n" +
                "\t}\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();

        CreditSubmitRequest request = mapper.readValue(json, CreditSubmitRequest.class);
        System.out.println(request);

        CreditSubmitResponse response = creditApprovalApi.submitCreditRequest(request);
        System.out.println(mapper.writeValueAsString(response));

    }
}
