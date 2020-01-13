package com.hl.official.website.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcmei
 * @date 2020-01-11
 * @description
 */
@Data
public class BaseResult implements Serializable {
    // 状态码
    private int status;

    // 自定义消息
    private String msg;

    // 请求的数据
    private Object data;

    /**
     * 成功的请求
     *
     * @param data
     * @return
     */
    public static BaseResult success(Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(200);
        baseResult.setMsg("请求成功");
        baseResult.setData(data);
        return baseResult;
    }

    /**
     * 失败的请求
     * @param status 状态码
     * @param msg 消息
     * @return
     */
    public static BaseResult fail(int status, String msg) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMsg(msg);
        return baseResult;
    }
}
