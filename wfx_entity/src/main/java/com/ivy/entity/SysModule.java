
package com.ivy.entity;


import java.io.Serializable;
import lombok.Data;

/**
* 实体类：
*
* @author 
* @date 2020-09-24 09:30:34
*/
@Data
public class SysModule implements Serializable {

        private String moduleCode;
        /**
        * 功能名称
        */
        private String moduleName;
        /**
        * 请求路径
        */
        private String linkUrl;
        /**
        * 排序编号
        */
        private Integer moduleOrder;
        /**
        * 上级功能
        */
        private String parentModule;
        /**
        * 权限描述
        */
        private String moduleDesc;
        /**
        * 是否展开
        */
        private String expanded;
        /**
        * 是否叶子节点
        */
        private String leaf;
}