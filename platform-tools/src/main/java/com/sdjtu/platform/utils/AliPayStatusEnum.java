package com.sdjtu.platform.utils;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:08
 */
public enum AliPayStatusEnum {

    /**
     * 交易成功
     */
    FINISHED("交易成功", "TRADE_FINISHED"),

    /**
     * 支付成功
     */
    SUCCESS("支付成功", "TRADE_SUCCESS"),

    /**
     * 交易创建
     */
    BUYER_PAY("交易创建", "WAIT_BUYER_PAY"),

    /**
     * 交易关闭
     */
    CLOSED("交易关闭", "TRADE_CLOSED");

    private String name;
    private String value;

    AliPayStatusEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
