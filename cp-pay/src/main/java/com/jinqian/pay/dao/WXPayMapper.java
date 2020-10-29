package com.jinqian.pay.dao;

import java.util.Map;

public interface WXPayMapper {
/**
 * 查询用户是否有未完成的订单
 *
 * */
Map queryOrder(Map<String, String> map);

/**
 *创建订单
 */
int createOrder(Map<String, String> map);

/**
 *查询订单状态
 */
Map queryOrderTime(Map<String, String> map);

/**
 * 更新订单
 */
Object updateOrder(Map<String, String> map);

/**
 *
 */
}

