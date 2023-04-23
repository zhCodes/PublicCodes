package com.zh.code.business.exception;

/**
 * @Date: 2023/4/12 11:13
 * @Author: Zhanghuihui
 * @Description: 全局异常统一处理
 */
public class BusinessException extends RuntimeException {

    private Integer errCode;
    private String errMsg;

    public BusinessException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
