package com.zh.publiccode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description 爬虫代理ip信息
 */
@Data
@TableName(value = "spider_proxy_ip_info")
public class SpiderProxyIpInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String host;

    private Integer port;

    private String type;

    private String addr;

}
