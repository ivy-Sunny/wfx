package com.ivy.service;

import com.ivy.entity.UserInfo;
import com.ivy.vo.LayuiVO;
import com.ivy.vo.ResultVO;
import com.ivy.vo.TreeNodeVO;

import java.util.List;

public interface UserInfoService {
    public ResultVO findUserByAccount(UserInfo userInfo);

    public List<TreeNodeVO> getModulesByIds(String userId);

    public LayuiVO findUserByPage(Integer page, Integer size);

    public ResultVO findUserInfoByUserId(String userId);
}
