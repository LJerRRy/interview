package job.netease;

import java.util.Scanner;

/**
 * Created by jerry on 2017/9/21.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] a = new int[i];
        for (int j = 0; j < i; j++) {
            a[i] = sc.nextInt();
        }
        i = sc.nextInt();
        int[] b = new int[i];
        for (int j = 0; j < i; j++) {
            b[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        if(A==null && B==null) return 0;    // 限定AB都不能为0

        int m=0,n=0;            // 存储AB的长度
        double k=0,preK=0;      // 存放length/2 以及 length/2-1 位的数字
        int length = 0;         // 存放整体长度
        if(A==null) m=0; else m = A.length;     // 对mn赋值
        if (B==null) n=0; else n = B.length;
        length = m+n;           // 对length赋值
        if(length<2){           // 如果AB中一个长度为0 另一个为1则直接返回
            if(m==0) return B[0];
            else return A[0];
        }

        int count = 0;
        int i=0,j=0;

        if(m==0){               // 只有B存在,A的长度为0,直接返回B的中位数
            if (length%2==0){
                return ((double)B[length/2]+(double)B[length/2-1])/2;
            }else
                return B[length/2];
        }else{
            if (n==0){          // 只有a存在
                if (length%2==0){
                    return ((double)A[length/2]+(double)A[length/2-1])/2;
                }else
                    return A[length/2];
            }
        }

        while (count<=length/2){    // 都存在时从头遍历,找到中间及其之前的一位数
            if((i<m && j<n && A[i]<=B[j])||(j>=n)){
                preK = k;
                k = A[i];
                ++i;
            }else{
                if((i<m && j<n && A[i]>B[j])||(i>=m)){
                    preK = k;
                    k = B[j];
                    ++j;
                }
            }

            ++count;
        }

        if (length%2 == 1){
            return k;
        }else {
            return (k+preK)/2;
        }
    }

}
