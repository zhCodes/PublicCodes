package com.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @Date: 2023/4/11 14:34
 * @Author: Zhanghuihui
 * @Description: 
 */
/**
    * 中国用户信息表
    */
@ApiModel(description="中国用户信息表")
@Data
public class ZUser {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 电子邮件
    */
    @ApiModelProperty(value="电子邮件")
    private String email;

    /**
    * 性别
    */
    @ApiModelProperty(value="性别")
    private Object gender;

    /**
    * 年龄
    */
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
    * 省份
    */
    @ApiModelProperty(value="省份")
    private String province;

    /**
    * 城市
    */
    @ApiModelProperty(value="城市")
    private String city;

    /**
    * 区/县
    */
    @ApiModelProperty(value="区/县")
    private String district;

    /**
    * 详细地址
    */
    @ApiModelProperty(value="详细地址")
    private String address;

    /**
    * 电话号码
    */
    @ApiModelProperty(value="电话号码")
    private String phone;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createdAt;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updatedAt;
}