package top.kou.will.pattern;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/3/8.
 */
public class ProxyPattern {
    interface ISource {
        void go();
    }

    static class Source implements ISource {
        public void go() {
            System.out.println("This is Source Method - ");
        }
    }

//    static class Proxy implements ISource {
//        private ISource source;
//
//        public Proxy(ISource source) {
//            this.source = source;
//        }
//
//        @Override
//        public void go() {
//            source.go();
//        }
//    }

    static class MyProxy implements InvocationHandler {

        private Object proxied;
        public MyProxy(Object object) {
            this.proxied = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("Before Invoke - ");

            Object result = method.invoke(proxied, args);

            System.out.print("After Invoke - ");

            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new MyProxy(new Source());
        ISource proxy = (ISource) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), new Class[]{ISource.class}, handler);
        proxy.go();
    }

}
