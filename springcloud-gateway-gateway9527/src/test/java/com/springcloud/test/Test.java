package com.springcloud.test;

import java.time.ZonedDateTime;

/**
 * @ClassName: Test
 * @author: dyh
 * @since: 2021/12/26 17:04
 */
public class Test {
    public static void main(String[] args) {
        ZonedDateTime time =  ZonedDateTime.now();//使用默认时间
        System.out.println(time);
        //2023-11-06T16:37:20.093+08:00[Asia/Taipei]
    }

}

