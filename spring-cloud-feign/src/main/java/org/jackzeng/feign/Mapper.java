package org.jackzeng.feign;

import java.io.IOException;

/**
 * @author xijin.zeng created on 2018/5/14
 */
public class Mapper {
    public static void main(String[] args) throws IOException {
        String json = "{\n" +
                "\t\"name\": \"里斯\",\n" +
                "\t\"ssn\": \"410881198012120101\",\n" +
                "\t\"telephone\": \"18612345678\",\n" +
                "\t\"timestamp\": 1514764800000,\n" +
                "\t\"channelId\": \"123\",\n" +
                "\t\"requestId\": \"XXXXX\",\n" +
                "\t\"channelData\": {\n" +
                "\t\t\"userId\": \"XXXXX\",\n" +
                "\t\t\"bankcardType\": \"debitcard\",\n" +
                "\t\t\"bankcardNo\": \"5187165812547896\",\n" +
                "\t\t\"minBudget\": 2000,\n" +
                "\t\t\"maxBudget\": 3000,\n" +
                "\t\t\"isFreshGraduate\": \"true\",\n" +
                "\t\t\"rentalCity\": \"上海\",\n" +
                "\t\t\"occupation\": \"\",\n" +
                "\t\t\"school\": \"上海交通大学\",\n" +
                //"\t\t\"graduationDate \": 1514764800000,\n" +
                "\t\t\"diplomaNo\": \"\",\n" +
                "\t\t\"company\": \"百度\",\n" +
                "\t\t\"jobPosition\": \"软件开发工程师\",\n" +
                "\t\t\"monthlySalary\": 8000\n" +
                "\t}\n" +
                "}";
//        ObjectMapper mapper = new ObjectMapper();
//
//        CreditSubmitRequest request = mapper.readValue(json, CreditSubmitRequest.class);
//        System.out.println(request);

        System.out.println(System.currentTimeMillis());

    }
}
