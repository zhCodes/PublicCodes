package com.zh.publiccode.service.impl;

import com.zh.publiccode.service.Animal;
import lombok.Data;

/**
 * @author zhanghuihui
 * @Date 2022/11/14 12:33
 * @Description
 */
@Data
public class Cat implements Animal {

    private  String name;
    @Override
    public void play() {
        System.out.println("....cat play...");
    }

    @Override
    public void eat() {
        System.out.println("....cat eat...");
    }

    public static void main(String[] args) {
        System.out.println("a");
    }
}
