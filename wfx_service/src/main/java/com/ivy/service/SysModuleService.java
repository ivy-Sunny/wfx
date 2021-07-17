package com.ivy.service;

import com.ivy.entity.SysModule;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;

import java.util.List;

public interface SysModuleService {
    LayuiVO<SysModule> search(Integer page, Integer limit, SysModule sysModule);

    ResultVO<SysModule> updateModule(SysModule sysModule);

    ResultVO<SysModule> deleteModule(String moduleCode);

    List<SysModule> findAllModule();
}
