package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/9.
 * 模板方法：定义一个操作中算法的框架，而将一些步骤延迟到子类中。模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 示例：其实 Spring 的 JdbcTemplate 、 JmsTemplate 最好的示例，跟回调是一回事
 */
public class TemplatePattern {
    static abstract class Template {
        public void doTask() {
            doActually();
        }

        protected abstract void doActually();
    }

    static class Ox extends Template {
        @Override
        protected void doActually() {
            System.out.println("Task is doing in Ox...");
        }
    }

    public static void main(String[] args) {
        Template template = new Ox();
        template.doTask();
    }
}
