package com.ivy.dao;

import com.ivy.entity.SysRole;
import com.ivy.entity.UserInfo;
import com.ivy.vo.TreeNodeVO;
import org.apache.ibatis.annotations.Select;

import javax.management.relation.RoleInfo;
import java.util.List;

public interface UserInfoDao {
    @Select("SELECT u.user_id, u.user_name, u.account, u.remark, u.user_type FROM user_info u " +
            "WHERE account = #{account} and password=#{password}")
    public UserInfo findUserByAccount(UserInfo userInfo);

    public List<TreeNodeVO> getModulesByIds(String userId);

    @Select("SELECT user_id, user_name, account, remark, user_type FROM user_info")
    public List<UserInfo> findAllUser();

    public SysRole findUserInfoByUserId(String userId);
}
