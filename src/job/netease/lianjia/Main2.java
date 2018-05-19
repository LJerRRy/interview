package job.netease.lianjia;

import java.util.Scanner;

/**
 * Created by jerry on 2017/10/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] val = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int j = sc.nextInt(), k = sc.nextInt();
            res += Math.min(val[j-1], val[k-1]);
        }
        System.out.println(res);
    }
}
