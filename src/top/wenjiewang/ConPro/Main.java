package top.wenjiewang.ConPro;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jerry on 2017/9/11.
 */
public class Main {
    public static void main(String[] args) {
        List<Phone> list =new LinkedList<>();
        Thread x1 = new Thread(new Producer(list, "XiaoMi"));
        Thread x2 = new Thread(new Producer(list, "XiaoMi"));
        Thread h1 = new Thread(new Producer(list, "d"));
        Thread h2 = new Thread(new Producer(list, "d"));
        Thread c1 = new Thread(new Consumer(list));
        Thread c2 = new Thread(new Producer(list, "d"));
        Thread c3 = new Thread(new Producer(list, "d"));
        Thread c4 = new Thread(new Producer(list, "d"));
        x1.start();
        x2.start();
        h1.start();
        h2.start();
        c1.start();
        c2.start();
        c3.start();
        Lock lock = new ReentrantLock();

    }
}
