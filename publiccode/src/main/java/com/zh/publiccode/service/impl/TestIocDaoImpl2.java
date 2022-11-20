package com.zh.publiccode.service.impl;

import com.zh.publiccode.service.TestIocDao;
import org.springframework.stereotype.Service;


/**
 * @author zhanghuihui
 * @Date 2022/11/16 16:36
 * @Description
 */
@Service
public class TestIocDaoImpl2 implements TestIocDao {

    @Override
    public void getMsg() {
        System.out.println("test getMsg222");
    }
}
