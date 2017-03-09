package top.kou.will.pattern;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/9.
 * 迭代器模式：提供一个遍历成员的方法，但又不暴露成员
 * 示例：其实这就是 Collection 的 iterator() 啦
 */
public class IteratorPattern {

    interface Iterable<E> {
        E first();
        E next();
        boolean hasNext();
    }

    static class Container<E> implements Iterable<E> {



        @Override
        public E first() {
            return null;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }

    static <T> T go(T x, T y) {
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(go("", 2.3).getClass());
    }

}
