package com.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.dao.SysRoleDao;
import com.ivy.entity.SysRole;
import com.ivy.service.SysRoleService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * SysRoleServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }

    @Override
    public LayuiVO<SysRole> findByPage(Integer page, Integer size) {
        //分页查询
        PageHelper.startPage(page, size);
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleDao.findAll());
        //封装layuiVO对象
        return new LayuiVO<>(pageInfo);
    }

    @Override
    public ResultVO saveRole(SysRole role) {
        role.setRoleCode(UUID.randomUUID().toString());
        int result = sysRoleDao.saveRole(role);
        if (result == 1) {
            return new ResultVO(role);
        } else {
            return new ResultVO(1, "添加角色失败");
        }
    }

    @Override
    public ResultVO updateRole(SysRole role) {
        int result = sysRoleDao.updateRole(role);
        if (result == 1) {
            return new ResultVO(role);
        } else {
            return new ResultVO(1, "修改角色失败");
        }
    }

    @Override
    public ResultVO delRole(String roleCode) {
        int result = sysRoleDao.delRole(roleCode);
        if (result == 1) {
            return new ResultVO(roleCode);
        } else {
            return new ResultVO(1, "删除角色失败");
        }
    }

    @Override
    public List<TreeNodeVO> findTree(String roleCode) {
        List<TreeNodeVO> tree = sysRoleDao.findTreeNode();
        List<String> checkedModules = sysRoleDao.findModuleIdsByRoleCode(roleCode);
        for (TreeNodeVO m1 : tree) {
            List<TreeNodeVO> m2 = m1.getChildren();
            for (TreeNodeVO m3 : m2) {
                if (checkedModules.contains(m3.getId())) {
                    m3.setChecked(true);
                }
            }
        }
        return tree;
    }

    @Override
    public ResultVO updateTree(String roleCode, String[] moduleCodes) {
        int delDelete = sysRoleDao.deleteTree(roleCode);
        System.out.printf("删除作用的列数：\t%d\n", delDelete);
        int result = 0;
        for (String moduleCode : moduleCodes) {
            result++;
            sysRoleDao.addTree(roleCode, moduleCode);
        }
        if (result > -1) {
            return new ResultVO(roleCode);
        } else {
            return new ResultVO(1, "角色授权失败");
        }
    }
}
