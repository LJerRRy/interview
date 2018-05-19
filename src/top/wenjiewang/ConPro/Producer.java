package top.wenjiewang.ConPro;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jerry on 2017/9/11.
 */
public class Producer implements Runnable {
    private final List<Phone> list;
    private String type;

    public Producer(List<Phone> list, String s) {
        this.type = s;
        this.list = list;
    }

    @Override
    public void run() {
        synchronized(list){
            for (int i = 0; i < 5; i++) {
                if (type.equals("XiaoMi")){
                    list.add(new XiaoMi());
                }else {
                    list.add(new HuaWei());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.notify();
        }
    }

    public static void main(String[] args) {
//        ThreadPoolExecutor
    }
}
