package com.ivy.controller;

import com.ivy.entity.UserInfo;
import com.ivy.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * IndexController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Controller
public class IndexController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/index")
    public String index(Model model, HttpSession session) {
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        model.addAttribute("moduleList", userInfoService.getModulesByIds(userinfo.getUserId()).get(0).getChildren());

        return "index";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/login")
    public String tologin() {
        return "login";
    }
}
