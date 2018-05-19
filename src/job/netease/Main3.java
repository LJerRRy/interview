package job.netease;

import java.util.Scanner;

/**
 * Created by jerry on 2017/9/16.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int m = sc.nextInt(), n = sc.nextInt();
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (sc.hasNextInt()){
                        a[i][j] = sc.nextInt();
                    }else {
                        System.out.println("input error");
                        return;
                    }
                }
            }

            int target;
            if (sc.hasNextInt()){
                target = sc.nextInt();
            }else {
                System.out.println("input error");
                return;
            }

        }catch (Exception e){
            System.out.println("input error");
        }
    }
}
