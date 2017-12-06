package com.rocketmq.util;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/12/5
 * Time: 19:34
 * Description:
 */
public class AliyunMessageProducer {

    private static final String ACCESS_KEY = "LTAIcV7Ho2KS9a64";
    private static final String SECRET_KEY = "3FWmAyWC99S3D8a3iVYzBZ0qiD4fOJ";


    /**
     * 获取消息的 Producer
     *
     * @param producerId producerId
     * @return Producer
     */
    public static Producer getProducer(String producerId) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, producerId);
        properties.put(PropertyKeyConst.AccessKey, ACCESS_KEY);
        properties.put(PropertyKeyConst.SecretKey, SECRET_KEY);
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        properties.put(PropertyKeyConst.ONSAddr,
                "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
        producer.start();
        return producer;
    }

    /**
     * 发布消息
     * @param producerId
     * @param msg
     * @return
     */
    public static SendResult sendMsg(String producerId,Message msg) {
        Producer producer = getProducer(producerId); //你申请的producerId
        SendResult send = producer.send(msg);
        return send;
    }



}