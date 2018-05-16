package org.jackzeng.feign;

import com.bkjk.credit.approvalservice.CreditApprovalSpiConfiguration;
import com.bkjk.credit.common.service.support.service.ServiceSupportConfig;
import com.bkjk.credit.datacollection.DataCollectionSpiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author xijin.zeng created on 2018/5/14
 */
@SpringBootApplication
@EnableFeignClients
@Import({ServiceSupportConfig.class, DataCollectionSpiConfiguration.class, CreditApprovalSpiConfiguration.class})
public class BootApp {

    @Autowired
    private TestService service;

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }

    @PostConstruct
    public void goTest() throws IOException {
        service.testApprovalApi();
    }
}
