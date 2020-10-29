package com.jinqian.pay.controller;


import com.github.wxpay.sdk.WXPayUtil;
import com.jinqian.cloundprint.entity.WXPayEntity;
import com.jinqian.pay.config.WxpayConfig;
import com.jinqian.pay.service.WXPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class WXPayController {
    @Resource(name = "wXPayServiceImpl")
    private WXPayService wXPayService;

    private WxpayConfig config ;
    private com.github.wxpay.sdk.WXPay wxPay ;
    public WXPayController() throws Exception {
        config = new WxpayConfig();
        wxPay = new com.github.wxpay.sdk.WXPay(config);
    }
    @RequestMapping("queryOrder")
    public Object queryOrder(WXPayEntity wx){
        return wXPayService.queryOrder(wx);
    }
    /**
     * 创建订单
     * */
    @RequestMapping("/createorder")
    public Object CreateOrder(WXPayEntity wx){
        return wXPayService.createOrder(wx);
    }
    /**
     * 创建订单
     * */
    @RequestMapping("/queryOrderTime")
    public Object queryOrderTime(WXPayEntity wx){
        return wXPayService.queryOrderTime(wx);
    }
    /**
     * 扫码支付主动查询
     * @return
     */
    @RequestMapping( "PayStatus")
    @ResponseBody
    public Map<String, String> queryWechatSaoPay(WXPayEntity wx){
        Map<String, String> resultMap = wXPayService.queryWeiXinPay(wx);
        return resultMap;
    }
}
