package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/7.
 * 建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 使用场景：众神造人，人必须有头、身、手、足，女娲造灵魂，只需要要头就可以，玉帝造全人
 */
public class BuilderPattern {
    static class Person {
        String head;
        String body;
        String hands;
        String feet;

        @Override
        public String toString() {
            return String.format("Person[head=%s, body=%s, hands=%s, feet=%s]", head, body, hands, feet);
        }
    }

    interface PersonBuilder {
        void buildHead();
        void buildBody();
        void buildHands();
        void buildFeet();
        Person getPerson();
    }

    static class FatPersonBuilder implements PersonBuilder {
        private Person person;

        public FatPersonBuilder() {
            person = new Person();
        }

        @Override
        public void buildHead() {
            person.head = "Fat Head";
        }

        @Override
        public void buildBody() {
            person.body = "Fat Body";
        }

        @Override
        public void buildHands() {
            person.hands = "Fat Hands";
        }

        @Override
        public void buildFeet() {
            person.feet = "Fat Feet";
        }

        @Override
        public Person getPerson() {
            return person;
        }
    }

    static class ThinPersonBuilder implements PersonBuilder {
        private Person person;

        public ThinPersonBuilder() {
            this.person = new Person();
        }

        @Override
        public void buildHead() {
            person.head = "Thin Head";
        }

        @Override
        public void buildBody() {
            person.body = "Thin Body";
        }

        @Override
        public void buildHands() {
            person.hands = "Thin Hands";
        }

        @Override
        public void buildFeet() {
            person.feet = "Thin Feet";
        }

        @Override
        public Person getPerson() {
            return person;
        }
    }

    interface Director {
        Person buildPerson(PersonBuilder builder);
    }

    static class King implements Director {
        @Override
        public Person buildPerson(PersonBuilder builder) {
            builder.buildHead();
            builder.buildBody();
            builder.buildHands();
            builder.buildFeet();
            return builder.getPerson();
        }
    }

    static class NuWa implements Director {
        @Override
        public Person buildPerson(PersonBuilder builder) {
            builder.buildHead();
            return builder.getPerson();
        }
    }

    public static void main(String[] args) {
        King king = new King();
        NuWa nuWa = new NuWa();

        System.out.println(king.buildPerson(new FatPersonBuilder()));
        System.out.println(nuWa.buildPerson(new ThinPersonBuilder()));
    }
}
