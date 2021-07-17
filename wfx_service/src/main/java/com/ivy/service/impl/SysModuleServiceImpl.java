package com.ivy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.dao.SysModuleDao;
import com.ivy.dao.SysRoleDao;
import com.ivy.entity.SysModule;
import com.ivy.service.SysModuleService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SysModuleServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-16
 */
@Service
@Transactional
public class SysModuleServiceImpl implements SysModuleService {
    @Autowired
    private SysModuleDao sysModuleDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public LayuiVO<SysModule> search(Integer page, Integer limit, SysModule sysModule) {
        PageHelper.startPage(page, limit);
        PageInfo<SysModule> pageInfo = new PageInfo<>(sysModuleDao.search(sysModule));
        return new LayuiVO(pageInfo);
    }

    @Override
    public ResultVO<SysModule> updateModule(SysModule sysModule) {
        boolean flag = isTailNode(sysModule.getModuleCode());
        if (!flag) {
            return new ResultVO<>(1, "该节点非叶节点，操作失败");
        }
        int result = sysModuleDao.updateModule(sysModule);
        if (result == 1) {
            return new ResultVO<>(sysModule);
        } else {
            return new ResultVO<>(1, "操作失败");
        }
    }

    @Override
    public ResultVO<SysModule> deleteModule(String moduleCode) {
        //todo 1:根据moduleCode获取children 表：sys_module
        //todo 2:判断，如果children不为null，或者children.size()>0，不允许操作
        //todo 3:如果children为null，直接删除   表1：sys_module,sys_role_fun
        boolean flag = isTailNode(moduleCode);
        if (!flag) {
            return new ResultVO<>(1, "该节点非叶节点，操作失败");
        }
        int result = sysModuleDao.deleteModule(moduleCode);
        if (result == 1) {
            return new ResultVO<>(0, "操作成功");
        } else {
            return new ResultVO<>(1, "操作失败");
        }
    }

    @Override
    public List<SysModule> findAllModule() {
        return sysModuleDao.findAllModule();
    }

    public boolean isTailNode(String moduleCode) {
        if (moduleCode != null && !"".equals(moduleCode)) {
            List<TreeNodeVO> tree = sysRoleDao.findTreeNode();
            for (TreeNodeVO m1 : tree) {
                if (moduleCode.equals(m1.getId()) && m1.getChildren().size() == 0) {
                    return true;
                }
                for (TreeNodeVO m2 : m1.getChildren()) {
                    if (moduleCode.equals(m2.getId()) && m2.getChildren().size() == 0) {
                        return true;
                    }
                    for (TreeNodeVO m3 : m2.getChildren()) {
                        if (moduleCode.equals(m3.getId())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
