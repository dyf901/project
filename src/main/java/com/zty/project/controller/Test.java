package com.zty.project.controller;

import org.springframework.util.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {
        /*SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间*/

        String sb = "340122000000000001 ";
        sb.substring(0, 18);
        System.out.println(sb.substring(0, 18));
    }

}
