package top.kou.will.pattern;

import java.io.*;

/**
 * Created by Administrator on 2017/3/7.
 */
public class PrototypePattern {

    static class Prototype implements Cloneable, Serializable {
        Object lock = new Object();

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Prototype deepClone() {
            try {
                ByteArrayOutputStream array = new ByteArrayOutputStream();

                ObjectOutputStream writer = new ObjectOutputStream(array);
                writer.writeObject(this);

                ObjectInputStream reader = new ObjectInputStream(new ByteArrayInputStream(array.toByteArray()));
                return (Prototype) reader.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Prototype prototype = new Prototype();
        Object a = prototype.clone();

        Object d = prototype.deepClone();

        System.out.println(prototype.lock + " - " + ((Prototype) a).lock + " - " + ((Prototype) d).lock);
    }
}
