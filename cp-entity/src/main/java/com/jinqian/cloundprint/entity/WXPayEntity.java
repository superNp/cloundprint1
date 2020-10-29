package com.jinqian.cloundprint.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WXPayEntity implements Serializable {
    private static final long serialVersionUID=1L;

    public WXPayEntity(String outTradeNo, String totalFee, String goodId,String body,String userid,String endtime) {
        this.outTradeNo = outTradeNo;
        this.totalFee = totalFee;
        this.goodId = goodId;
        this.body = body;
        this.userid = userid;
        this.endtime = endtime;
    }

    public WXPayEntity() {

    }

    private String outTradeNo;//商户订单号
    private String totalFee;//商品价格
    private String goodId;//订单ID
    private String body;//商品
    private String userid;//商品
    private String endtime;//时间
    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    public String getOutTradeNo() {
        return outTradeNo;
    }
    public String getTotalFee() {
        return totalFee;
    }



    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
    @Override
    public String toString() {
        return "WXPay{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", totalFee='" + totalFee + '\'' +
                ", goodId='" + goodId + '\'' +
                ", body='" + body + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
