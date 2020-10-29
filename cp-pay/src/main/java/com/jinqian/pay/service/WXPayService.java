package com.jinqian.pay.service;

import com.jinqian.cloundprint.entity.WXPayEntity;

import java.util.Map;

public interface WXPayService {
    Map<String, String> queryOrder(WXPayEntity wx);
    Map<String, String> queryOrderTime(WXPayEntity wx);
    Map<String,String> createOrder(WXPayEntity wx);
    Map<String, String> queryWeiXinPay(WXPayEntity wx);
}
