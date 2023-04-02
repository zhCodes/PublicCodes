package com.zh.publiccode.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private Integer id;
    private String userName;
    private String password;
    private Integer phone;

}
