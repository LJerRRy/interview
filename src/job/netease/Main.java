package job.netease;

/**
 * Created by jerry on 2017/8/12.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int[] c = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c[c1]>0)continue;
            c[c1]++;
            sb.append(c1);
        }
        System.out.println(sb.toString());
    }
}
