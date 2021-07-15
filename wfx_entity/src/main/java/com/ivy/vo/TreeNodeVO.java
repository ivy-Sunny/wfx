package com.ivy.vo;

import lombok.Data;

import java.util.List;

/**
 * TreeNodeVO
 *
 * @Author: ivy
 * @CreateTime: 2021-07-15
 */
@Data
public class TreeNodeVO {
    private String id;

    private String title;

    private boolean spread = true;

    private boolean checked;

    private List<TreeNodeVO> children;
}
