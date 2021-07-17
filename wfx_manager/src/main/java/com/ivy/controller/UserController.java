package com.ivy.controller;

import com.ivy.entity.SysRole;
import com.ivy.entity.UserInfo;
import com.ivy.service.SysRoleService;
import com.ivy.service.UserInfoService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * UserController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-16
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysRoleService sysRoleService;

    @GetMapping("/login")
    @ResponseBody
    public ResultVO login(HttpSession session, UserInfo userInfo) {
        ResultVO model = userInfoService.findUserByAccount(userInfo);
        if (model.getCode() == 0) {
            session.setAttribute("userinfo", model.getData());
        }
        return model;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        List<SysRole> all = sysRoleService.findAll();
        model.addAttribute("roles", all);
        return "user";
    }

    @RequestMapping("/findUserByPage")
    @ResponseBody
    public LayuiVO findUserByPage(Integer page, Integer limit) {
        return userInfoService.findUserByPage(page, limit);
    }
}
