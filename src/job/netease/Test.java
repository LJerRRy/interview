package job.netease;

/**
 * Created by jerry on 2017/9/27.
 */
public class Test {
    public int maxStipend(int numOfDays, int[][] taskList)
    {
        // WRITE YOUR CODE HERE
        int[] dp = new int[numOfDays+1];
        int res = 0;
        for(int i = 1;i<=numOfDays;i++){
            int tmp = 0;
            if(i>1){
                tmp = Math.max(dp[i-2]+taskList[i-1][1], dp[i-1]+taskList[i-1][0]);
            }
            dp[i] = Math.max(tmp, dp[i-1]+taskList[i-1][0]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxStipend2(int numOfDays, int[][] taskList)
    {
        // WRITE YOUR CODE HERE
        if(numOfDays==0)return 0;
        int[] dp = new int[numOfDays+1];
        int res = 0;
        dp[1] = Math.max(taskList[0][1], taskList[0][0]);
        res = Math.max(res,dp[1]);
        for(int i = 2;i<=numOfDays;i++){
            int tmp = Math.max(dp[i-2]+taskList[i-1][1], dp[i-1]+taskList[i-1][0]);

            dp[i] = Math.max(tmp, dp[i-1]+taskList[i-1][0]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
       Test t = new Test();
       int tmp = t.maxStipend2(4, new int[][]{{1,2},{4,10},{20,21},{2,23}});
        System.out.println(tmp);
    }
}
