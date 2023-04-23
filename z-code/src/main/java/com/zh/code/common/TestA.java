package com.zh.code.common;

public class TestA {


    public static void testMethod() {
        String str = "aaa";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuffer.append(str);
        stringBuffer.append("bbbb");
        String s = stringBuffer.toString();
        System.out.println(s);


    }

    public static void main(String[] args) {
//        testMethod();
        String s="abcde";
        for (int i = s.length(); i >0 ; i--) {
            char c = s.charAt(i-1);
            System.out.println(c);
        }
    }

}
