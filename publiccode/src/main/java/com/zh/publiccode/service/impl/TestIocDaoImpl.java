package com.zh.publiccode.service.impl;

import com.zh.publiccode.service.TestIocDao;
import org.springframework.stereotype.Service;

/**
 * @author zhanghuihui
 * @Date 2022/11/16 16:35
 * @Description
 */
@Service
public class TestIocDaoImpl implements TestIocDao {


    @Override
    public void getMsg() {
        System.out.println("test getMsg 111");
    }
}
