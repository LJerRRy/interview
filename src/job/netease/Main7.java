package job.netease;

import java.util.Scanner;

/**
 * Created by jerry on 2017/9/25.
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if (a>s||b>s||c>s){
            System.out.println(0);
        }else{
            double d = cfun(s, a);
            double e = cfun(s, b);
            double f = cfun(s, c);
            System.out.println((d*e*f)%1000000007);
        }
    }
    private static double cfun(int s, int a){
        double fenmu = 1.0;
        for (int i = 1; i <= a; i++) {
            fenmu*=i;
        }
        double fenzi = 1.0;
        for (int i = 0; i < a; i++) {
            fenzi *= (s-i);
        }
        return fenzi / fenmu;
    }
}
