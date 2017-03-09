package top.kou.will.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/9.
 * 享元模式：复用我们内存中已存在的对象，降低系统创建对象实例
 * 示例：链接池
 */
public class SharePattern {
    static class ConnectionPoll {
        private final static Set<Connection> CONNECTIONS = new HashSet<Connection>();
        static {
            for (int i = 0; i < 10; i ++) {
                try {
                    CONNECTIONS.add(DriverManager.getConnection(""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Connection getConnection() {
            if (!CONNECTIONS.isEmpty()) {
                synchronized (CONNECTIONS) {
                    return CONNECTIONS.iterator().next();
                }
            }
            return null;
        }

        public void release(Connection connection) {
            CONNECTIONS.add(connection);
        }

    }

}
