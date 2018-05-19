package job.netease.lianjia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jerry on 2017/10/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt(), arg = sc.nextInt();
        int[][] k = new int[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            k[i][0] = sc.nextInt();
            k[i][1] = sc.nextInt();
            sum += k[i][0];
        }
        if (sum*1.0/n>=arg){
            System.out.println(0);
            return;
        }
        Arrays.sort(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        long sub = (long) arg * n - sum;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (sub <= 0) break;
            if (r - k[i][0] <= 0) continue;

            if ((r - k[i][0]) < sub) {
                res += (r - k[i][0]) * k[i][1];
                sub -= r - k[i][0];
            } else {
                res += sub * k[i][1];
                break;
            }

        }
        System.out.println(res);
    }

}
