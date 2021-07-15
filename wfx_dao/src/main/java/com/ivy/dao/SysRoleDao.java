package com.ivy.dao;

import com.ivy.entity.SysRole;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysRoleDao {
    @Select("SELECT * FROM sys_role")
    public List<SysRole> findAll();

    @Insert("INSERT INTO sys_role(role_code,role_name,role_desc) " +
            "VALUES(#{roleCode},#{roleName},#{roleDesc})")
    public int saveRole(SysRole role);

    @Update("UPDATE sys_role SET role_name = #{roleName}, role_desc = #{roleDesc} WHERE role_code = #{roleCode}")
    public int updateRole(SysRole role);

    @Delete("DELETE FROM sys_role WHERE role_code = #{roleCode}")
    public int delRole(String roleCode);

    public List<TreeNodeVO> findTreeNode();

    public List<String> findModuleIdsByRoleCode(String roleCode);

    public int addTree(@Param("role_id") String roleId, @Param("module_id") String moduleId);

    public int deleteTree(String roleId);
}
