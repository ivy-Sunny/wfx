package com.ivy.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * ResultVO
 *
 * @Author: ivy
 * @CreateTime: 2021-07-14
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private boolean success;
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        if (code == 0) {
            this.success = true;
        } else {
            this.success = false;
        }
        this.msg = msg;
        this.code = code;
    }

    public ResultVO(T data) {
        this.code = 0;
        this.msg = "success";
        this.success = true;
        this.data = data;
    }
}
