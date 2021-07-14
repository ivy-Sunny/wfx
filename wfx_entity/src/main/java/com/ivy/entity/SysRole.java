package com.ivy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体类：角色表 *
 *
 * @author
 * @date 2021-07-14 08:56:19
 */
@Data
public class SysRole implements Serializable {

    /**
     * 角色编码
     */

    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 角色排序
     */
    private Integer roleOrder;

    /**
     * 角色类型 1:业务角色;2:管理角色;
     */
    private Integer roleType;
}