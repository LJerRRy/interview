package job.netease.huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jerry on 2017/9/26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Pattern pattern = Pattern.compile("(\\d)-(\\d{3})-(\\d{5})");
        Matcher matcher = pattern.matcher(s);
        if (!matcher.find()||s.length()>11){
            System.out.println("ERROR");
        }else{
            String a = matcher.group(1);
            String b = matcher.group(2);
            String c = matcher.group(3);
            int l = a.charAt(0)-'0';
            for (int i = 0; i < b.length(); i++) {
                l += (b.charAt(i) - '0') * (i+2);
            }
            for (int i = 0; i < c.length(); i++) {
                l += (c.charAt(i) - '0') * (i+5);
            }
            System.out.println(s+"-"+((l%11)>9?"X":(l%11)));
        }
    }
}
