package com.ivy.dao;

import com.ivy.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleDao {
    @Select("SELECT * FROM sys_role")
    public List<SysRole> findAll();
}
