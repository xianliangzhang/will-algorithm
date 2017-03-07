package top.kou.will.pattern;

import top.kou.will.pattern.factory.Sender;
import top.kou.will.pattern.factory.impl.EmailSender;
import top.kou.will.pattern.factory.impl.SmsSender;

/**
 * Created by Administrator on 2017/3/7.
 */
public class AbstractFactoryPattern {
    public interface Provider {
        Sender provide();
    }

    static class SmsSenderFactory implements Provider {
        @Override
        public Sender provide() {
            return new SmsSender();
        }
    }

    static class EmailSenderFactory implements Provider {
        @Override
        public Sender provide() {
            return new EmailSender();
        }
    }

    public static void main(String[] args) {
        new SmsSenderFactory().provide().send();
    }
}
