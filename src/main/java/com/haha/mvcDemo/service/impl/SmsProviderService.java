package com.haha.mvcDemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haha.mvcDemo.domain.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class SmsProviderService {
    @Resource(name = "activeMqJmsTemplate")
    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "sessionAwareQueue")
    private Destination destination;
    private static final Logger logger = LoggerFactory.getLogger(SmsProviderService.class);

    public void createSms(final Sms sms) {
        jmsTemplate.send( /*destination,*/new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                logger.info("*****************生成短信*****************");
                return session.createTextMessage(JSONObject.toJSONString(sms));
            }
        });
    }
}
