package com.jinqian.cloundprint.utlis;

/**
 * 自定义返回消息
 */
public class ResultMessage {

    private String code;

    private Object messageContent;

    private String message;




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(Object messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
