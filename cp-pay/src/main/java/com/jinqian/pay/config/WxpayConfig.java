package com.jinqian.pay.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WxpayConfig implements WXPayConfig {
    private byte[] certData;

    public WxpayConfig() throws Exception {
        String certPath = "C:\\test\\WXCertUtil\\cert\\apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public String getAppID() {
        return "wx423f64adddb48cc9";
    }

    public String getMchID() {
        return "1602818697";
    }

    public String getKey() {
        return "12A23BC23s397b54gLMT6428Y9361DB7";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
    public static final String DOMAIN_API = "api.mch.weixin.qq.com";
    IWXPayDomain getWXPayDomain() {

        // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {

            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(DOMAIN_API, true);
            }
        };
        return iwxPayDomain;

    }
}
