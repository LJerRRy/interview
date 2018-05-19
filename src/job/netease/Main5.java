package job.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jerry on 2017/9/25.
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int[] fr = new int[n];
        for (int i = 0; i < n; i++) {
            fr[i] = sc.nextInt();
        }
        Arrays.sort(fr);
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i<n/2){
                right = Math.max(fr[i]+s, right);
                left = Math.min(fr[i]+s,left);
            }else{
                left = Math.min(fr[i]-s, left);
                right = Math.max(fr[i]-s, right);
            }
        }
        System.out.println(right-left);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), s = sc.nextInt();
//        int[] fr = new int[n];
//        for (int i = 0; i < n; i++) {
//            fr[i] = sc.nextInt();
//        }
//        int[] min = new int[1];
//        min[0] = Integer.MAX_VALUE;
//        fun(fr, 0, min, s);
//        System.out.println(min[0]);
//    }
//
//    private static void  fun(int[] a, int cur, int[] min, int s){
//        if (cur == a.length-1){
//            int[] c = Arrays.copyOf(a, a.length);
//            Arrays.sort(c);
//            min[0] = Math.min(Math.abs(c[0]-c[c.length-1]), min[0]);
//            return;
//        }
//        int tmp = a[cur];
//        for (int i = 0; i < 2; i++) {
//            if (i == 0){
//                a[cur] += s;
//                fun(a, cur+1, min, s);
//                a[cur] -= s;
//            }else {
//                a[cur] -= s;
//                fun(a, cur+1, min, s);
//                a[cur] += s;
//            }
//        }
//    }

}
