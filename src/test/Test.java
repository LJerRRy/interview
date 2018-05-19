package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 2017/8/1.
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String item : list){
            if ("2".equals(item)){
                list.remove(item);
            }
        }
        System.out.println(list);
    }


}
