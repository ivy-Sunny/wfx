package com.ivy.controller;

import com.ivy.entity.SysModule;
import com.ivy.service.SysModuleService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * ModuleController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-15
 */
@Controller
@RequestMapping("/module/")
public class ModuleController {
    @Resource
    private SysModuleService sysModuleService;

    @RequestMapping("index")
    public String index(Model model) {
        //获取所有的权限列表
        List<SysModule> sysModules = sysModuleService.findAllModule();
        System.out.println(sysModules);
        model.addAttribute("modules", sysModules);
        return "module";
    }

    @GetMapping("/searchByPage")
    @ResponseBody
    public LayuiVO<SysModule> searchByPage(Integer page, Integer limit, SysModule sysModule) {
        return sysModuleService.search(page, limit, sysModule);
    }

    @PostMapping("/updateModule")
    @ResponseBody
    public ResultVO<SysModule> updateModule(SysModule sysModule) {
        return sysModuleService.updateModule(sysModule);
    }
}
