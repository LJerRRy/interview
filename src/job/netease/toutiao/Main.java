package job.netease.toutiao;

import java.util.*;

/**
 * Created by jerry on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] num = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if(min>num[i])min = num[i];
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (min == num[i])list.add(i);
        }

        for (int may:list){
            boolean flag = true;
            int[] tmp = Arrays.copyOf(num, num.length);
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(may==x) {
                    if (num[i] < num[may]) {
                        flag = false;
                        break;
                    }else{
                        num[i] -= num[may];
                        sum+=num[may];
                    }
                }else if(may<x){
                    if ((may<i&&i<=x)&&num[i] < num[may] + 1) {
                        flag = false;
                        break;
                    }
                    if (num[i] < num[may]){
                        flag = false;
                        break;
                    }
                    if (may<i&&i<=x){
                        num[i] -= num[may] + 1;
                        sum+=num[may]+1;
                    }else{
                        num[i] -= num[may];
                        sum+=num[may];
                    }
                }else{
                    if ((i>may||i<=x)&&num[i] < num[may] + 1){
                        flag = false;
                        break;
                    }
                    if (num[i] < num[may]){
                        flag = false;
                        break;
                    }
                    if(i>may||i<=x){
                        num[i] -= num[may] + 1;
                        sum+=num[may]+1;
                    }
                    else{
                        num[i] -= num[may];
                        sum+=num[may];
                    }
                }
            }
            if (flag) {
                num[may] = sum;
                break;
            }
            num = tmp;
//            if(flag){
//                int sum = 0;
//                for (int i = 0; i < n; i++) {
//                    if(may==x) {
//                        num[i] = num[i] - num[may];
//                        sum += num[may];
//                    }else if(may<x){
//                        if (((may < i) && (i <= x))) {
//                            num[i] = num[i] - num[may] - 1;
//                        }else if (num[i] < num[may]){
//                            flag = false;
//                            break;
//                        }
//                    }else{
//                        if ((i>may||i<=x)&&num[i] < num[may] + 1){
//                            flag = false;
//                            break;
//                        }else if (num[i] < num[may]){
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//                break;
//            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(num[i]);
            if (i!=n-1){
                System.out.print(' ');
            }
        }
    }

}

