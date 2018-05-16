package org.jackzeng.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xijin.zeng created on 2018/5/12
 */
@RestController
public class TestController {

    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String getMethod() {
        return "HI";
    }

}
