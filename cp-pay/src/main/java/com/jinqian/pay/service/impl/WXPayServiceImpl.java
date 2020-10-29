package com.jinqian.pay.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.jinqian.cloundprint.entity.WXPayEntity;
import com.jinqian.pay.config.WxpayConfig;
import com.jinqian.pay.dao.WXPayMapper;
import com.jinqian.pay.service.WXPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("wXPayServiceImpl")
public class WXPayServiceImpl implements WXPayService {
    @Autowired
    private WXPayMapper wxPayMapper;
    private WxpayConfig config ;
    private com.github.wxpay.sdk.WXPay wxPay ;
    public WXPayServiceImpl() throws Exception {
        config = new WxpayConfig();
        wxPay = new com.github.wxpay.sdk.WXPay(config);
    }

    @Override
    public Map<String, String> queryOrder(WXPayEntity wx) {
        Map<String,String> data = new HashMap<>();
        //检查订单是否存在
        data.put("userid",wx.getUserid());//商户订单号
        Map<String,String> queryMap  = wxPayMapper.queryOrder(data);
        if(queryMap!=null&&queryMap.size()>0){
            //生成支付订单直接返回
            if(queryMap.get("code_url")!=null&&!queryMap.get("code_url").equals("null")){
                queryMap.put("first","N");
            }
            queryMap.put("return_code","SUCCESS");
            queryMap.put("result_code","SUCCESS");
        }
        return queryMap;
    }

    @Override
    public Map<String, String> queryOrderTime(WXPayEntity wx) {
        Map<String,String> data = new HashMap<>();
        //检查订单是否存在
        data.put("outtradeno",wx.getOutTradeNo());//商户订单号
        data.put("endtime",wx.getEndtime());//截止时间
        Map<String,String> queryMap  = wxPayMapper.queryOrderTime(data);
        return queryMap;
    }

    public  Map<String,String> createOrder(WXPayEntity wx){
        Map<String,String> data = new HashMap<>();
        //调用微信支付
        data.put("out_trade_no",wx.getOutTradeNo());//商户订单号
        data.put("appid",config.getAppID());
        data.put("mch_id",config.getMchID());         //商户号
        data.put("trade_type","APP");                         //支付场景 APP 微信app支付 JSAPI 公众号支付  NATIVE 扫码支付
        data.put("notify_url","http://88xiwa.natappfree.cc/notifyurl");                     //回调地址
        data.put("spbill_create_ip","127.0.0.1");             //终端ip
        data.put("total_fee","1");//总费用 wx.getTotalFee()
        data.put("fee_type","CNY");                           //默认人民币
        data.put("body",wx.getBody());
        data.put("nonce_str",UUID.randomUUID().toString().replace("-","").toUpperCase());   // 随机字符串小于32位
        Map<String,String> dataresp = null;
        try {
            String s = WXPayUtil.generateSignature(data, config.getKey());//签名
            data.put("sign",s);
            data.put("trade_type","NATIVE");
            //获取生成二维码的url
            dataresp = wxPay.unifiedOrder(data);
            System.out.println("统一下单："+dataresp.toString());
            if(dataresp.get("return_code").equals("SUCCESS")){
                if(dataresp.get("result_code").equals("SUCCESS")){
                    dataresp.put("id",UUID.randomUUID().toString().replace("-","").toUpperCase());
                    dataresp.put("outtradeno",wx.getOutTradeNo());
                    dataresp.put("totalfree",wx.getTotalFee());
                    dataresp.put("body",wx.getBody());
                    dataresp.put("userid",wx.getUserid());
                    dataresp.put("endtime",wx.getEndtime());
                    dataresp.put("zfbz","N");
                    dataresp.put("yxbz","Y");
                    dataresp.put("first","Y");
                    int i = wxPayMapper.createOrder(dataresp);
                    System.out.println(i>0?"订单保存成功":"订单保存失败");
                }else{
                    System.out.println("下单失败："+dataresp.get("err_code")+"：描述："+dataresp.get("err_code_des"));
                }
            }else{
                System.out.println("通信失败："+dataresp.get("return_code")+"：描述："+dataresp.get("return_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOperatorId("231");
        refundRequest.setRefundFee(1);
        refundRequest.setRefundFeeType("CNY");
        refundRequest.setRefundNumber("1");
        refundRequest.setTotalFee(1);
        refundRequest.setTransactionId("4200000682202009279300802881");
        Payments.defaultOrders().refund(refundRequest);*/
        return dataresp;

    }
    /**
     * 调用微信支付查询接口，返回支付信息
     * @return
     * @throws
     */
    @Override
    public Map<String, String> queryWeiXinPay(WXPayEntity wx) {
        System.out.println("*************************调用支付查询 start*************************");
        Map<String, String> resultMap = new HashMap<String, String>();
        String out_trade_no = wx.getOutTradeNo();
        String merId = config.getMchID();
        if( out_trade_no == null || out_trade_no.trim().equals("")){
            resultMap.put("return_code", "0");
            resultMap.put("return_msg", "订单号为空");
            return resultMap;
        }
        if( merId == null || merId.trim().equals("")){
            resultMap.put("return_code", "0");
            resultMap.put("return_msg", "商户号为空");
            return resultMap;
        }
        try {//查询微信支付状态
            Map<String, String> rspWeiXinData = queryWeiXinSaoPay(out_trade_no);
            System.out.println(rspWeiXinData.toString());
            if(rspWeiXinData==null||rspWeiXinData.isEmpty()){
                resultMap.put("return_code", "0");
                resultMap.put("return_msg","查询支付状态失败!");
                return resultMap;
            }else{
                resultMap.put("data",rspWeiXinData.toString());
                String total_fee =  rspWeiXinData.get("total_fee");//交易金额
                resultMap.put("trade_state", rspWeiXinData.get("trade_state"));
                resultMap.put("total_fee", total_fee);
                resultMap.put("orderId", out_trade_no);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("return_code", "0");
            resultMap.put("return_msg","查询支付状态失败!");
            return resultMap;
        }

        return resultMap;
    }

    public Map<String, String> queryWeiXinSaoPay(String orderId) {
        Map<String, String> resp  = null;
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", orderId);//订单号
        try{
            resp = wxPay.orderQuery(data);
            String return_code = resp.get("return_code");
            String result_code = resp.get("result_code");
            String err_code = resp.get("err_code");
            String err_code_des = resp.get("err_code_des");
            String trade_state = resp.get("trade_state");
            String trade_state_desc = resp.get("trade_state_desc");
            if("SUCCESS".equals(return_code)){//微信返回状态码为成功
                if("SUCCESS".equals(result_code)){//业务结果状态码为成功
                    if("SUCCESS".equals(trade_state)){//交易状态为成功
                        System.out.println("交易完成");
                        //todo
                        return resp;
                    }else if("USERPAYING".equals(trade_state)){
                        //支付中
                        return resp;
                    }
                    else{
                        //交易状态为不是成功
                        System.out.println("***************支付平台订单ID:"+orderId+"查询微信支付接口异常:trade_state="+trade_state+",trade_state_desc="+trade_state_desc);
                        return resp;
                    }
                }
                else{
                    //业务结果状态码为失败
                    System.out.println("***************支付平台订单ID:"+orderId+"查询微信支付接口异常:err_code="+err_code+",err_code_des="+err_code_des);
                    return resp;
                }
            }
            else{
                //微信返回状态码为失败
                System.out.println("***************支付平台订单ID:"+orderId+"查询微信支付接口异常:"+err_code);
                return resp;
            }

        }
        catch(Exception e){
            System.out.println("***************支付平台订单ID:"+orderId+"查询微信支付接口:"+e.getMessage());
            e.printStackTrace();
        }
        //仅返回交易状态trade_state是SUCCESS的值
        return resp;
    }

}
