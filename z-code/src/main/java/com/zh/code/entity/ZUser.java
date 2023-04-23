package com.zh.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Date: 2023/4/11 14:34
 * @Author: Zhanghuihui
 * @Description: 
 */
@ApiModel(description="用户信息表")
@Data
public class ZUser {
    @ApiModelProperty(value="主键")
    @TableId(type = IdType.AUTO)
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
    private String gender;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt=new Date();

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间")
    private Date updatedAt;
}