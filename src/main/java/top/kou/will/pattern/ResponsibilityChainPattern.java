package top.kou.will.pattern;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/3/10.
 * 责任链模式：一个请求在一串处理器上传递，直到被处理，但发出请求时，并不知道将会被哪个处理器处理
 */
public class ResponsibilityChainPattern {
    static class Request {
        final int index;
        int processTimes;

        public Request(int index) {
            this.index = index;
        }

        public void process() {
            processTimes++;
        }
    }

    static class Handler {
        private int key;
        private String name;

        Handler(int key, String name) {
            this.key = key;
            this.name = name;
        }

        void handle(Request request) {
            if (key % request.index == 0) {
                request.process();
                System.out.println(String.format("Process Request [requestId=%d, handlerId=%d]", request.index, key));
            }
        }
    }

    static class Server extends Thread {
        private final static Set<Handler> HANDLERS = new HashSet<Handler>();
        private final static BlockingQueue<Request> QUEUE = new LinkedBlockingQueue<Request>();
        static {
            try {
                for (int i = 0; i < 10; i ++) {
                    HANDLERS.add(new Handler(i, String.valueOf(i)));
                }
            } catch (Exception e) {
                ;
            }
        }

        public void accept(Request request) {
            QUEUE.add(request);
            System.out.println("Queue - " + QUEUE.size());
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                HANDLERS.forEach(r -> {
                    try {
                        r.handle(QUEUE.take());
                    } catch (Exception e) {
                        e.printStackTrace();
                        interrupt();
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();

        new Thread() {

            int x = 0;

            @Override
            public void run() {
                for (int i = 0; i < 100; i ++) {
                    server.accept(new Request(++x));
                }
            }

        }.start();

    }
}
