package com.zh.publiccode.service.impl;

import com.zh.publiccode.service.TestIocDao;
import com.zh.publiccode.service.TestIocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghuihui
 * @Date 2022/11/16 16:53
 * @Description
 */
@Service
public class TestIocServiceImpl implements TestIocService {

//    @Resource(name = "testIocDaoImpl2")
    @Autowired
    private TestIocDao testIocDaoImpl2;

    @Override
    public void testMethod() {
        testIocDaoImpl2.getMsg();

    }

}
