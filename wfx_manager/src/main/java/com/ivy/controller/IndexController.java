package com.ivy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String demo() {
        return "demo";
    }
}
