package job.netease.huawei;

import java.util.Scanner;

/**
 * Created by jerry on 2017/9/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        int[] ch = new int[256];
        for (int i = 0; i < a.length(); i++) {
            ch[a.charAt(i)] = 1;
        }
        for (int i = 0; i < b.length(); i++) {
            if(ch[b.charAt(i)]==1) {
                ch[b.charAt(i)] = 2;
            }
        }
        for (int i = 0; i < a.length(); i++) {
            if (ch[a.charAt(i)]==2){
                System.out.print("_");
            }else {
                System.out.print(a.charAt(i));
            }
        }
        System.out.println();
        for (int i = 0; i < b.length(); i++) {
            if (ch[b.charAt(i)]==2){
                System.out.print("_");
            }else{
                System.out.print(b.charAt(i));
            }
        }
    }
}
