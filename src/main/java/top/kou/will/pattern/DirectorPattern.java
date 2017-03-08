package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/8.
 * 装饰器模式
 */
public class DirectorPattern {
    static class Source {
        public void go() {
            System.out.print("This is source-method...");
        }
    }

    static class Director {
        private Source source;

        public Director(Source source) {
            this.source = source;
        }

        public void go() {
            System.out.println("Before Direct - ");
            source.go();
            System.out.println("After Direct - ");
        }
    }

}
