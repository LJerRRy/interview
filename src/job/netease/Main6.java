package job.netease;

import java.util.Scanner;

/**
 * Created by jerry on 2017/9/25.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        if (n*6<x){
            System.out.println(0);
            return;
        }else if (n>x){
            System.out.println(1);
            return;
        }


    }

}
