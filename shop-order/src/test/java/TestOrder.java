import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.common.domain.AliPaySuccessMsg;
import org.apache.catalina.startup.EngineConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.EncryptionKey;

import javax.activation.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: AT
 * @Date: 2020/8/6 10:35 上午
 */
public class TestOrder {
    public static void main(String[] args) {
        String str= "{\"gmt_create\":[\"2020-07-30 16:47:41\"],\"charset\":[\"utf-8\"],\"seller_email\":[\"bluhlj3996@sandbox.com\"],\"subject\":[\"用户购买会员卡\"],\"sign\":[\"Hlc3ed4r5vKfY1x+/O1tAWobLLIlQSFU/9v2OHXMrRpk0k/8CSruU5FdRn+q4l4eTaUPZwg/I58Et14ix+IfJj5HtoW5uEf1W8Me56IUZl9GgK77e4IymBoeV22qRwLR5fJtG+xVJwW6B0/UO//5mkY3+b5Z8FM/TpKmT+oh3Z2rrTkh0faOVtLDx0BTgDjJW4Sxinoi+pn+CVePbT92/A7Uww2CTY/0rAMarbQkmaTxicUQea1tdz8gFEK1CYsA+jvSWVhqSkpkiZXg72Ipa+Rne1fkce6GP/FSH91Nsd5+SP8mKsIt+WSbjTSt9bBULsP5cWzjk7EPoXOWzuBL4g==\"],\"body\":[\"用户ID ：64\"],\"buyer_id\":[\"2088102181184790\"],\"invoice_amount\":[\"0.01\"],\"notify_id\":[\"2020073000222164744084790507499024\"],\"fund_bill_list\":[\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"ALIPAYACCOUNT\\\"}]\"],\"notify_type\":[\"trade_status_sync\"],\"trade_status\":[\"TRADE_SUCCESS\"],\"receipt_amount\":[\"0.01\"],\"app_id\":[\"2016102700771020\"],\"buyer_pay_amount\":[\"0.01\"],\"sign_type\":[\"RSA2\"],\"seller_id\":[\"2088102181266353\"],\"gmt_payment\":[\"2020-07-30 16:47:43\"],\"notify_time\":[\"2020-07-30 16:50:21\"],\"version\":[\"1.0\"],\"out_trade_no\":[\"MCO2020073064654165\"],\"total_amount\":[\"0.01\"],\"trade_no\":[\"2020073022001484790501085415\"],\"auth_app_id\":[\"2016102700771020\"],\"buyer_logon_id\":[\"efg***@sandbox.com\"],\"point_amount\":[\"0.00\"]}\n";
//
        String replace = str.replace("[", "").replace("]", "");

        AliPaySuccessMsg paySuccessMsg = JSONObject.parseObject(replace, AliPaySuccessMsg.class);

        Map<String, Object> map = BeanUtil.beanToMap(paySuccessMsg);

        Map<String, Object> map1 = BeanUtil.beanToMap(paySuccessMsg, false, false);

        System.out.println(map1.size());


//        EncryptionUtil

    }
}
