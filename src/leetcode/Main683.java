package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jerry on 2017/9/27.
 */
public class Main683 {
    String res;

    public static void main(String[] args) {
        Main683 main683 = new Main683();
        System.out.println(main683.nextClosestTime("19:34"));
    }

    public String nextClosestTime(String time) {
        List<Integer> num = new LinkedList<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i)>='0'&&time.charAt(i)<='9'){
                if (!num.contains(time.charAt(i)-'0')){
                    num.add(time.charAt(i)-'0');
                }
            }
        }
        num.sort((a,b)->(a-b));
        fun(num, new int[]{24*60}, Integer.parseInt(time.split(":")[0]),
                Integer.parseInt(time.split(":")[1]), new LinkedList<>());
        return res;
    }

    private void fun(List<Integer> num, int[] min, int hour, int minute, List<Integer> tmp){
        if (tmp.size()==4){
            int h = tmp.get(0)*10+tmp.get(1);
            int m = tmp.get(2)*10+tmp.get(3);
            if (h>=24||m>=60||(h==hour&&m==minute))return;
            int diff = ((h - hour + 24)%24) * 60 + (m - minute + 60) % 60;
            if (diff<min[0]){
                res = "" + h + ":" + m;
                min[0] = diff;
            }
        }else {
            for (int i = 0; i < num.size(); i++) {
                tmp.add(num.get(i));
                fun(num, min, hour, minute, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
