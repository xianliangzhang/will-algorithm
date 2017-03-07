package top.kou.will.pattern;

import org.springframework.context.annotation.Lazy;

/**
 * Created by Administrator on 2017/3/7.
 * 单例模式
 */
public class SingletonPattern {

    /**
     * 懒加载单例模式
     */
    static class LazySingleton {
        private static LazySingleton instance = null;

        private LazySingleton() {}

        public LazySingleton getInstance() {
            if (null == instance) {
                synchronized (LazySingleton.class) {
                    if (null == instance) {
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }

        /**
         * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
         */
        public Object readResolve() {
            return instance;
        }
    }

    /**
     * 饿加载单例模式
     */
    static class NonLazySingleton {
        private static final NonLazySingleton instance = new NonLazySingleton();

        private NonLazySingleton() {}

        public NonLazySingleton getInstance() {
            return instance;
        }

        /**
         * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
         */
        public Object readResolve() {
            return instance;
        }
    }

}
