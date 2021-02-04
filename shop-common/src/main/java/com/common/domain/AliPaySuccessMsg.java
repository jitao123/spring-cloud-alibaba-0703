package com.common.domain;

import lombok.Data;

/**
 * @description: 支付宝支付返回的信息转化成对象
 * @author: AT
 * @String: 2020/8/3 9:39 上午
 */
@Data
public class AliPaySuccessMsg {

    /**通知时间 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss	2015-14-27 15:45:58*/
    private String notify_time;
    /**通知类型*/
    private String notify_type;
    /**通知校验ID*/
    private String notify_id;
    /**开发者的app_id*/
    private String app_id;
    /**编码格式*/
    private String charset;
    /**接口版本*/
    private String version;
    /**签名类型*/
    private String sign_type;
    /**签名*/
    private String sign;
    /**支付宝交易凭证号*/
    private String trade_no;
    /**原支付请求的商户订单号*/
    private String out_trade_no;
    /** 商户业务ID，主要是退款通知中返回退款申请的流水号*/
    private String out_biz_no;
    /**买家支付宝账号对应的支付宝唯一 用户号。以2088开头的纯16位数字*/
    private String buyer_id;
    /**买家支付宝 账号*/
    private String buyer_logon_id;
    /**卖家支付宝 用户号*/
    private String seller_id;
    /** 卖家支付宝 账号*/
    private String seller_email;
    /**交易目前所处的状态，见交易状态说明*/
    private String trade_status;
    /** 本次交易支付的 订单金额*/
    private String total_amount;
    /**商家在交易中实际收到的款项 实收金额*/
    private String receipt_amount;
    /**开票金额	否	用户在交易中支付的可开发票的金额	*/
    private String invoice_amount;
    /** 用户在交易中支付的金额 否*/
    private String buyer_pay_amount;
    /** 集分宝金额	 否*/
    private String point_amount;
    /** 总退款金额	 否*/
    private String refund_fee;
    /**商品的标题/交易标题/订单标题/订单关键字等*/
    private String subject;
    /**该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来*/
    private String body;
    /**该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss*/
    private String gmt_create;
    /**该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss*/
    private String gmt_payment;
    /**该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S*/
    private String gmt_refund;
    /**该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss*/
    private String gmt_close;
    /** 支付成功的各个渠道金额信息,array*/
    private String fund_bill_list;
    /**公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。*/
    private String passback_params;

    /**返回的参数中携带了，支付宝api文档中未定义,应该是复验appId*/
    private String auth_app_id;


}
