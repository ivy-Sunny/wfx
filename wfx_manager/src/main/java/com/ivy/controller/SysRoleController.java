package com.ivy.controller;

import com.ivy.entity.SysRole;
import com.ivy.service.SysRoleService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/delRole")
    @ResponseBody
    public ResultVO delRole(String roleCode) {
        return sysRoleService.delRole(roleCode);
    }

    @GetMapping("/findTree")
    @ResponseBody
    public List<TreeNodeVO> findTree(String roleCode) {
        return sysRoleService.findTree(roleCode);
    }

    @PostMapping("/updateTree")
    @ResponseBody
    public ResultVO updateTree(@RequestParam("roleCode") String roleCode, @RequestParam("checkedIds") String checkedIds) {
        String[] moduleIds = checkedIds
                .substring(1, checkedIds.length() - 1)
                .replace("\"", "")
                .split(",");
        return sysRoleService.updateTree(roleCode, moduleIds);
    }
}
