package top.kou.will.pattern;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/9.
 * 组合模式
 */
public class CompositePattern {
    static abstract class Composite {
        protected String name;
        protected Composite parent;
        protected Set<Composite> children = new HashSet<Composite>();

        protected String getName() {
          return this.name;
        }

        protected Composite getParent() {
            return this.parent;
        }

        protected Set<Composite> getChildren() {
            return this.children;
        }

        protected void add(Composite child) {
            this.children.add(child);
        }

        protected void remove(Composite child) {
            this.children.remove(child);
        }
    }

    static class Family extends Composite {
        Set<Composite> children = new LinkedHashSet<Composite>();

        @Override
        public String getName() {
            return "Family";
        }
    }

    static class Father extends Composite {

        public Father(String name, Composite parent) {
            super();
            this.name = name;
            this.parent = parent;
        }
    }

    static class Son extends Composite {
        public Son(String name, Composite parent) {
            super();
            this.name = name;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Family family = new Family();

        Father father = new Father("Father", family);
        family.add(father);

        Son one = new Son("Son One", father);
        Son two = new Son("Son One", father);
        Son thr = new Son("Son One", father);
        Son fou = new Son("Son One", father);
        father.add(one);
        father.add(two);
        father.add(thr);
        father.add(fou);
    }
}
