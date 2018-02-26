package com.haha.mvcDemo.service;

import java.util.List;
import java.util.Map;

/**
 * 短信推送服务
 * 需要解决的问题：高并发下一次行推送太多的信息会导致系统瘫痪
 * 解决方案：将短信推送的任务全都放到队列中来
 * 队列选择：选择消息中间件代替Java自带的队列，因为Java自带的队列来处理发送邮件、短信等业务的时候，如果服务器当机所有的消息都会被清空，不利于运营，弱国
 * 在中间件中的话，如果服务器宕机的情况下可以将未完成的任务通过中间件来拦截，对因服务器当机造成的影响降到最低
 */
public interface SMSPushService {

    /**
     * 推送一条短信
     */
    public void pushOneSms(String from, String to, String msg);

    /**
     * 发送多条短信 默认同步推送
     */
    public void synchronizedPushMultiSms(List<String> from, List<String> tos, String msg);

    /**
     * 异步发送推送信息
     */
    public void asyncPushMultiSms(Map<String, String> msg);
}
