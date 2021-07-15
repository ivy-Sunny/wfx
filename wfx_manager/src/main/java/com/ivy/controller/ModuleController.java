package com.ivy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ModuleController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-15
 */
@Controller
@RequestMapping("/module/")
public class ModuleController {
    @RequestMapping("index")
    public String index(){
        return "module";
    }

    @RequestMapping("/searchByPage")
    @ResponseBody
    public void searchByPage(){

    }
 }
