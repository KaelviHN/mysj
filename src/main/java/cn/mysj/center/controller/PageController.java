package cn.mysj.center.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: anran.ma
 * @created: 2024/9/28
 * @description:
 **/
@Controller
public class PageController {
    private static final Logger log = LogManager.getLogger(PageController.class);

    @GetMapping("to_login")
    public String login(){
        log.info("login");
        return "/login";
    }

    @GetMapping("/to_index")
    public String index(){
        log.info("index");
        return "/index";
    }

}
