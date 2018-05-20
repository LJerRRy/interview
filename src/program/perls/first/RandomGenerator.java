package program.perls.first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jerry on 2018/5/20.
 */
public class RandomGenerator {
    public static String filePath = "/Users/jerry/Desktop/jerry/interview/src/program/perls/first/data";
    public static int N = 10000000;

    public static void generate() {
        String filePath = getPath();
        File file = new File(filePath);
        if (file.exists()) return;
        List<Integer> a = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            a.add(i);
        }
        Collections.shuffle(a);
        System.out.println(a.get(100));

        FileWriter fw = null;
        long startTime = System.currentTimeMillis();
        try {
            fw = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            for (int i = 0; i < N; i++) {
                bufferedWriter.write(String.valueOf(a.get(i)));
                bufferedWriter.write(" ");
                if ((i+1) % 10 == 0) {
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    public static String getPath(){
        Date date = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return filePath + "/" + simpleFormatter.format(date) + ".txt";
    }

    public static void main(String[] args) {
        RandomGenerator.generate();
    }
}
