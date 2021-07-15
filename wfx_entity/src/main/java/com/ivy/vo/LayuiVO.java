package com.ivy.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * LayuiVO
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Data
public class LayuiVO<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public LayuiVO() {
    }

    public LayuiVO(PageInfo<T> pageInfo) {
        this.code = 0;
        this.msg = "success";
        this.count = (int) pageInfo.getTotal();
        this.data = pageInfo.getList();
    }

    public LayuiVO(Integer code) {
        this.code = code;
        if (code == 0) {
            this.msg = "success";
            this.count = 0;
            this.data = null;
        } else {
            this.msg = "failed";
            this.count = 0;
            this.data = null;
        }
    }
}
