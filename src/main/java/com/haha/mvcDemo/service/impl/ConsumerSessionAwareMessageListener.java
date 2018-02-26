package com.haha.mvcDemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haha.mvcDemo.domain.Sms;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.Session;


@Resource(name = "consumerSessionAwareMessageListener")
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message> {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerSessionAwareMessageListener.class);

    @Override
    public synchronized void onMessage(Message message, Session session) {
        try {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            final String ms = msg.getText();
            Sms sms = JSONObject.parseObject(ms, Sms.class);
            if (null == sms) {
                return;
            }
            sendSms(sms);
        } catch (Exception e) {
            logger.error("================>>>>消费者接受消息出错：" + e.getMessage());
        }
    }

    /**
     * 模拟消息发送
     */
    private void sendSms(Sms sms) {

        threadPoolTaskExecutor.execute(() -> {
            try {
                logger.info("消费者收到的信息：==============>>>>>>>>" + sms.getMsg());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
