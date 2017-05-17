package org.jackzeng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XijinZeng on 2017/5/9.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(){
        return "index.html";
    }
}
