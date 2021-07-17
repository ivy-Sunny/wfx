package com.ivy.dao;

import com.ivy.entity.SysModule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysModuleDao {
    public List<SysModule> search(SysModule sysModule);

    @Insert("UPDATE sys_module SET module_name = #{moduleName},link_url = #{linkUrl} " +
            "WHERE module_code = #{moduleCode}")
    public int updateModule(SysModule sysModule);

    @Delete("DELETE FROM sys_module sm, sys_role_fun srf WHERE sm.module_code = #{moduleCode} AND srf.module_id = #{moduleCode}")
    public int deleteModule(String moduleCode);

    @Select("SELECT * FROM sys_module")
    public List<SysModule> findAllModule();
}
