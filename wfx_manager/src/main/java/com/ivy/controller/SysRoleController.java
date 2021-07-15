package com.ivy.controller;

import com.ivy.entity.SysRole;
import com.ivy.service.SysRoleService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SysRoleController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Controller
@RequestMapping("/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/index")
    public String index() {
        return "role";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<SysRole> findAll() {
        List<SysRole> list = sysRoleService.findAll();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public LayuiVO<SysRole> findByPage(Integer page, Integer limit) {
        return sysRoleService.findByPage(page, limit);
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO saveRole(SysRole role) {
        return sysRoleService.saveRole(role);
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public ResultVO updateRole(SysRole role) {
        return sysRoleService.updateRole(role);
    }

    @RequestMapping("/delRole")
    @ResponseBody
    public ResultVO delRole(String roleCode) {
        return sysRoleService.delRole(roleCode);
    }
}
