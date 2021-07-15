package com.ivy.service;

import com.ivy.entity.SysRole;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;

import java.util.List;

public interface SysRoleService {
    public List<SysRole> findAll();

    public LayuiVO<SysRole> findByPage(Integer page,Integer size);

    public ResultVO saveRole(SysRole role);

    public ResultVO updateRole(SysRole role);

    public ResultVO delRole(String roleCode);
}
