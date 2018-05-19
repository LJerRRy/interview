package job.netease.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by jerry on 2017/9/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("\\|");
        String[][] sort = new String[s.length][2];
        for (int i = 0; i < s.length; i++) {
            sort[i][0] = reverseDomin(s[i]);
            sort[i][1] = "" + i;
        }
        Arrays.sort(sort, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

//        Arrays.sort(sort, (o1, o2) -> (o1[0].compareTo(o2[0])));
        for (int i = 0; i < sort.length; i++) {
            System.out.print(s[sort[i][1].charAt(0)-'0']);
            if (i!=s.length-1){
                System.out.print("|");
            }
        }
    }
    static String reverseDomin(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String[] t = sb.toString().split("\\.");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            res.append(reverse(t[i]));
            if (i!=t.length-1){
                res.append(".");
            }
        }
        return res.toString();
    }

    static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

}
