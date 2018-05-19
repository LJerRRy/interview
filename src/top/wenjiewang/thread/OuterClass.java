package top.wenjiewang.thread;

/**
 * Created by jerry on 2017/9/7.
 */
public class OuterClass {
    static class InnerClass{
        private String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }
}
