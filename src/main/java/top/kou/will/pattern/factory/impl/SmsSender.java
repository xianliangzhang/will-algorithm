package top.kou.will.pattern.factory.impl;

import top.kou.will.pattern.factory.Sender;

/**
 * Created by Administrator on 2017/3/7.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("Send Sms...");
    }
}
