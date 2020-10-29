package com.jinqian.cloundprint.utlis;


import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
public class JQUtils {
    /*
    获取本机IP
     */

    public static String getIp(){
        //获取IP地址
        InetAddress ip4 = null;
        try {
            ip4 = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //切割
        String[] split = ip4.toString().split("/");
        String IP = split[1];
        log.info("工具类本机IP------{}",IP);


        return IP;
    }

}
