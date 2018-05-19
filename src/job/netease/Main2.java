package job.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jerry on 2017/8/12.
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tmp = x[i]+" " + y[i];
            if (map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)+1);
            }else {
                map.put(tmp, 1);
            }
        }
        int max = 0;
        for (Integer i:map.values()){
            max = Math.max(max, i);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsValue(i + 1)) {
                System.out.print(0);
            } else {
                int min = 0;
                for (int j = 0; j < n; j++) {
                    int tmp = 0;
                    for (int k = 0; k < n; k++) {
                        tmp += Math.abs(x[j] - x[k]) + Math.abs(y[j] - y[k]);
                    }
                    min = Math.min(tmp, min);
                }
                System.out.print(min);
            }
            if (i != n-1) {
                System.out.println();
            }
        }
    }

    private int minOperation(int[] x, int[] y, int target){
        if ((x!=null)&(x.length==0));
        return 0;
    }
}
