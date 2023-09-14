package com.zh.publiccode.testwebspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public class JavaCon {

    public  static void  saveData() throws SQLException {


        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false","root","1234");
        Random random = new Random();
        int i = random.nextInt(100);
        String value1="测试"+i;
        String sql="insert into test_save(name) value("+"'"+ value1+"'"+");";
        System.out.println("sql:"+sql);
        Statement statement = connection.createStatement();

        statement.execute(sql);
        connection.close();
    }



}
