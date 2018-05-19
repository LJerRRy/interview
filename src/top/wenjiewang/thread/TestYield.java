package top.wenjiewang.thread;

/**
 * Created by jerry on 2017/9/7.
 */
public class TestYield {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new MyThread());
        a.start();
        Thread.sleep(100);

        System.out.println("he");
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        long begint = System.currentTimeMillis();
        int i = 0, cout = 0;
        for(;  i<50000000; i++) {
            cout = i+cout;
            Thread.yield();
            if (i%10000000==0){
                System.out.println(i);
            }
        }
        System.out.println(System.currentTimeMillis()-begint);
    }
}

class MyObject{
    private String a = "aa";
    private String b = "bb";
    public void setV(String a, String b){
        this.a = a;
        if (Thread.currentThread().getName().equals("a")) {
            Thread.yield();
        }
//        Thread.currentThread().resume();
        this.b = b;
    }
    public void print(){
        System.out.println(a + " " + b);
    }
}
