package program.perls.first;

import java.io.*;
import java.util.Arrays;

/**
 * Created by jerry on 2018/5/20.
 */
public class Exercise3 {
    private static String filePath = RandomGenerator.getPath();
    public static void main(String[] args) {
        Exercise3 test = new Exercise3();
        test.calQSortTime();
        test.calBitVectorTime();


    }

    Exercise3() {
        // 生成随机数文件
        RandomGenerator.generate();
    }

    /**
     * 计算通过位向量进行排序10000000个数的时间
     * 最后实验结果时间为：1283
     */
    public void calBitVectorTime() {
        long startTime = System.currentTimeMillis();
        BitVector bitVector = new BitVector();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("开始vector排序");
            String line = br.readLine();
            while (line != null) {
                String[] nums = line.split(" ");
                for (String num : nums) {
                    bitVector.add(Integer.parseInt(num));
                }
                line = br.readLine();
            }
            System.out.println("vector排序结束");
            br.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("BitVector进行排序耗时："+(System.currentTimeMillis() - startTime));
    }

    /**
     * 计算通过系统库排序方法Arrays.sort的方式的时间
     * 最后实验结果时间为：2889
     */
    public void calQSortTime() {
        long startTime = System.currentTimeMillis();
        File file = new File(filePath);
        int[] arr = new int[RandomGenerator.N];
        int i = 0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            System.out.println("开始Arrays.sort排序");
            while (line != null) {
                String[] nums = line.split(" ");
                for (String num : nums) {
                    if (num == null)continue;
                    arr[i++] = Integer.parseInt(num);
                }
                line = br.readLine();

            }
            System.out.println(i);
            br.close();
            fileReader.close();
            Arrays.sort(arr);
            System.out.println("Arrays.sort排序结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Arrays.sort()进行排序耗时：" + (System.currentTimeMillis() - startTime));
    }


}
