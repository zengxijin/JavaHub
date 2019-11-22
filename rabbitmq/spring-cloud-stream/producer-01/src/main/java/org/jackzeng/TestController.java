package org.jackzeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xijin.zeng created on 2019/8/6
 */
@RestController
public class TestController {

    @Autowired
    private ProduceService service;

    int i = 0;

    @GetMapping(path = "/get")
    public String get() {
        service.produceNewEvent(new LogMessage(String.valueOf(++i)));
        return String.valueOf(i);
    }
}
