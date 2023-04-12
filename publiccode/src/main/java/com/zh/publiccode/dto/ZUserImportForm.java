package com.zh.publiccode.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Date: 2023/4/12 10:39
 * @Author: Zhanghuihui
 * @Description:
 */
@Data
@ToString
public class ZUserImportForm {
    /**
     * 用户名
     */
    @ExcelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ExcelProperty(value="密码")
    private String password;

    /**
     * 电子邮件
     */
    @ExcelProperty(value="电子邮件")
    private String email;

    /**
     * 性别
     */
    @ExcelProperty(value="性别")
    private String gender;

    /**
     * 年龄
     */
    @ExcelProperty(value="年龄")
    private Integer age;

    /**
     * 省份
     */
    @ExcelProperty(value="省份")
    private String province;

    /**
     * 城市
     */
    @ExcelProperty(value="城市")
    private String city;

    /**
     * 区/县
     */
    @ExcelProperty(value="区/县")
    private String district;

    /**
     * 详细地址
     */
    @ExcelProperty(value="详细地址")
    private String address;

    /**
     * 电话号码
     */
    @ExcelProperty(value="电话号码")
    private String phone;
}
