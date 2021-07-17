package com.ivy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.dao.UserInfoDao;
import com.ivy.entity.UserInfo;
import com.ivy.service.UserInfoService;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * SysUserInfoServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-16
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public ResultVO findUserByAccount(UserInfo userInfo) {
        UserInfo user = userInfoDao.findUserByAccount(userInfo);
        if (user == null) {
            return new ResultVO<>(1, "密码错误");
        } else {
            return new ResultVO(user);
        }
    }

    @Override
    public List<TreeNodeVO> getModulesByIds(String userId) {
        return userInfoDao.getModulesByIds(userId);
    }

    @Override
    public LayuiVO findUserByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        PageInfo pageInfo = new PageInfo(userInfoDao.findAllUser());
        return new LayuiVO(pageInfo);
    }

    @Override
    public ResultVO findUserInfoByUserId(String userId) {

        return null;
    }
}
