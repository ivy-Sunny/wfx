package com.ivy.service.impl;

import com.ivy.dao.SysRoleDao;
import com.ivy.entity.SysRole;
import com.ivy.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SysRoleServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }
}
