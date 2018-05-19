package leetcode;

import java.util.List;

/**
 * Created by jerry on 2017/8/4.
 */
public class Test_50 {
    public double myPow(double x, int n) {
        if (n==0)return 1.0;
        boolean isNeg = false;
        if (n<0){
            isNeg = true;
            n = -n;
            System.out.println(n);
            System.out.println(Math.abs(n));
        }
        double t = 1.0;
        while (n>=1){
            if ((n&1)==1)
                t *= x;
            x *= x;
//            t *= x;
            n /= 2;
        }
        return isNeg?1.0/t:t;
    }

    public static void main(String[] args) {
        Test_50 t = new Test_50();
        System.out.println(t.MoreHalf(new int[]{1,2,1,1,3,3,3,1}));
//        System.out.println(t.binary_search(new int[]{1,2,3,4}, 0, 3, 4));
//        System.out.println(t.binary_search_find_first(new int[]{1,1,2,3,4}, 0, 4, 1));
//        System.out.println(t.binary_search_find_last(new int[]{1,1,2,3,4}, 0, 4, 1));
//        System.out.println("Hello World!");
//        System.out.println(t.myPow(5,-2147483648) +" "+Math.pow(5,-2147483648));
    }

//    public List<TreeNode> findBoud(TreeNode root){
//
//    }

    public int binary_search(int[] a, int start, int end, int target){
        if(start>end||start<0||end>a.length-1)return -1;
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(a[mid] > target){
                end = mid - 1;
            }else if(a[mid] > target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int binary_search_find_first(int[] a, int left, int right, int target){
        if(left>right||left<0||right>a.length-1)return -1;
        while (left<=right){
            int mid = left + (right - left) / 2;

            if (left == right && a[mid] == target)return mid;
            if (a[mid] > target){
                right = mid - 1;
            }else if(a[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
//            if (a[mid] > target){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
        }
        return  -1;
    }

    public int binary_search_find_last(int[] a, int left, int right, int target){
        if(left>right||left<0||right>a.length-1)return -1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if((left + right)%2 == 1)  //向上取整 ceil function
                mid++;
            if (left == right && a[mid] == target)return mid;
            if (a[mid] < target){
                left = mid + 1;
            }else if(a[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }

//            if (a[mid] > target){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
        }
        return  -1;
    }

    public int MoreHalf(int[] nums) {
        int res = 0;
        int count = 0;
        if (nums.length == 0)
            return -1;
        res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count < 0) {
                res = nums[i];
                count = 0;
                continue;
            }
            if (res == nums[i])
                count++;
            else
                count--;
        }
        count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(res == nums[i])count++;
        }
        if(count > nums.length/2)
            return res ;
        return 0;
    }


    class TreeNode{
        TreeNode left, right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
