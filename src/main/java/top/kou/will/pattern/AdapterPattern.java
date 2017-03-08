package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/8.
 */
public class AdapterPattern {
    static class Source {
        public void speak() {
            System.out.println("世界你好！");
        }
    }

    interface Target {
        void speakChinese();
        void speakEnglish();
        void speakFrench();
    }

    static class InheritTarget extends Source implements Target {

        @Override
        public void speakChinese() {
            speak();
        }

        @Override
        public void speakEnglish() {
            speak();
            System.out.println(" - Translate to English is --- ");
        }

        @Override
        public void speakFrench() {
            speak();
            System.out.println(" - Translate to French is --- ");
        }
    }

    static class WrapperSourceTarget implements Target {
        private Source source;

        public WrapperSourceTarget(Source source) {
            this.source = source;
        }

        @Override
        public void speakChinese() {
            source.speak();
        }

        @Override
        public void speakEnglish() {
            source.speak();
            System.out.println(" - Translate to English is --- ");
        }

        @Override
        public void speakFrench() {
            source.speak();
            System.out.println(" - Translate to French is --- ");
        }
    }

}
