package com.hotel.sofiter.service.impl;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest01 {

    @Test
    public void test1(){
        String time = "2019-03-01 10:54:12.0";

        String substring = time.substring(time.lastIndexOf("."));
        System.out.println(substring);

//        Date date=new Date("2019-03-01 10:54:12");

//        System.out.println(date.toString());
//        DateFormat.
        DateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //设置日期格式
        dformat.setLenient(false);
        //指定日期/时间解析是否不严格。进行不严格解析时，
        // 解析程序可以使用启发式的方法来解释与此对象的格式不精确匹配的输入。
        // 进行严格解析时，输入必须匹配此对象的格式。


        try {
            Timestamp ts = new Timestamp(dformat.parse(time).getTime());
            System.out.println(ts.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        Timestamp timestamp=Timestamp.valueOf(dformat.format(date)) ;
    }
    @Test
    public void test2(){
        String time = "2019-03-01 10:54:12.0";

        String substring = time.substring(time.lastIndexOf("."));
        int i = time.indexOf(".");

        System.out.println(i);
        System.out.println(time.substring(0,i ));
    }
}
