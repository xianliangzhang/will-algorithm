package top.kou.will.pattern;

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

    static class Container<E> {
        private E[] container = (E[]) new Object[0];
        private int size = 0;

        public void add(E e) {
            size++;
            E[] tempContainer = (E[]) new Object[size];
            System.arraycopy(container, 0, tempContainer, 0, container.length);
            tempContainer[size - 1] = e;
            container = tempContainer;
        }

        public void remove(E e) {
            int index = -1;
            for (int i = 0; i < container.length; i++) {
                if (container[i].equals(e)) {
                    index = i;
                    break;
                }
            }

            if (-1 != index) {
                E[] tempContainer = (E[]) new Object[container.length - 1];
                for (int i = 0; i < container.length; i++) {
                    if (i < index) {
                        tempContainer[i] = container[i];
                    }
                    if (i > index) {
                        tempContainer[i - 1] = container[i];
                    }
                }
                container = tempContainer;
                size--;
            }
        }

        Iterable<E> iterator() {
            return new Iterable<E>() {
                int i = 0;

                @Override
                public E first() {
                    return size == 0 ? null : container[0];
                }

                @Override
                public E next() {
                    return container[i++];
                }

                @Override
                public boolean hasNext() {
                    return size == 0 ? false : i > size - 1 ? false : true;
                }
            };
        }
    }

    static class Gender implements Comparable<Gender> {

        @Override
        public int compareTo(Gender o) {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        Container<Integer> container = new Container<Integer>();
        container.add(3);
        container.add(5);
        container.add(7);

        Iterable<Integer> iterable = container.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }

        container.remove(5);
        iterable = container.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }

    }

}
