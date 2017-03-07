package top.kou.will.pattern;

import top.kou.will.pattern.factory.Sender;
import top.kou.will.pattern.factory.impl.EmailSender;
import top.kou.will.pattern.factory.impl.SmsSender;

/**
 * Created by Administrator on 2017/3/7.
 * 工厂方法模式
 */
public class FactoryMethodPattern {

    static class BeanFactory {
        static Sender getSmsSender() {
            return new SmsSender();
        }

        static Sender getEmailSender() {
            return new EmailSender();
        }
    }
}
