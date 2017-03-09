package top.kou.will.pattern;

import com.sun.javafx.css.SubCssMetaData;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/9.
 * 观察者模式
 */
public class ObserverPattern {
    static class Event {
        final Subject subject;

        Event(Subject subject) {
            this.subject = subject;
        }
    }

    static class Observer {
        private String name;

        Observer(String name) {
            this.name = name;
        }

        void update(Event event) {
            String message = String.format("[%s] - Received - %s", name, event);
            System.out.println(message);
        }
    }

    static abstract class Subject {
        private Set<Observer> OBSERVERS = new HashSet<Observer>();

        public void register(Observer observer) {
            this.OBSERVERS.add(observer);
        }

        public void notifyUpdate() {
            OBSERVERS.forEach(o -> {
                try {
                    o.update(new Event(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        @Override
        public String toString() {
            return String.format("%s - Notified.", getClass().getName());
        }
    }

    // 各种天气
    static class SunnyWeatherPredict extends Subject {

    }
    static class StormWeatherPredict extends Subject {

    }
    static class ThunderWeatherPredict extends Subject {

    }

    public static void main(String[] args) {
        Observer a = new Observer("a");
        Observer b = new Observer("b");
        Observer c = new Observer("c");

        Subject sunny = new SunnyWeatherPredict();
        Subject storm = new StormWeatherPredict();
        Subject thunder = new ThunderWeatherPredict();

        sunny.register(a);
        sunny.register(b);

        storm.register(b);

        thunder.register(a);
        thunder.register(b);
        thunder.register(c);

        new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        switch ((int) (Math.random() * 10)) {
                            case 1:
                                sunny.notifyUpdate();
                                break;

                            case 2:
                                storm.notifyUpdate();
                                break;

                            case 3:
                                thunder.notifyUpdate();
                                break;
                        }
                    } catch (Exception e) {
                        interrupt();
                    }
                }
            }
        }.start();
    }

}
