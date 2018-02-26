package com.haha.mvcDemo.controller;

import com.haha.mvcDemo.domain.Sms;
import com.haha.mvcDemo.service.impl.SmsProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Autowired
    private SmsProviderService smsProviderService;

    private int count = 0;
    private static final Logger logger = LoggerFactory.getLogger(SmsController.class);

    @ResponseBody
    @RequestMapping("sms")
    public String test() {

//        LongStream.range(count, count + 100).forEach(
//                () -> {
//                    Sms sms = new Sms();
//                    smsProviderService.createSms(sms);
//                }
//        );
        for (int i = count; i < count + 100; i++) {
            Sms sms = new Sms(i+"","消息内容"+i);
            smsProviderService.createSms(sms);
        }
        count += 100;
        logger.info("count===============>>>>>>>>>  "+count);
        return "index";
    }

}
