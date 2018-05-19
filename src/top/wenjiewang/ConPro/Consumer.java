package top.wenjiewang.ConPro;

import java.util.List;

/**
 * Created by jerry on 2017/9/11.
 */
public class Consumer implements Runnable{
    private final List<Phone> list;

    public Consumer(List<Phone> list) {
        this.list = list;
    }


    @Override
    public void run() {
        synchronized(list){
            // 如果没有则等待
            if (list.size()<=0){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 继续消费
            Phone phone = list.remove(0);
            phone.print();
            phone = null; // help GC
        }
    }
}
