package com.zh.publiccode.config;

/**
 * @Date: 2023/4/11 17:25
 * @Author: Zhanghuihui
 * @Description: 统一返回
 */
public class Response<T> {
    // 响应码
    private int code;
    // 响应消息
    private String message;
    // 响应数据
    private T data;
    public Response() {
    }
    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    // 成功响应
    public static <T> Response<T> success(T data) {
        return new Response<>(200, "success", data);
    }

    // 失败响应
    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message, null);
    }

    // 自定义响应
    public static <T> Response<T> custom(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
