package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jerry on 2017/9/28.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int cnt = 0;
//        double[] d = new double[n];
        List<Double> list = new ArrayList<>();
        double t = Double.parseDouble(reader.readLine());
        int k = 0;
        while(k<n){
            Double d = Double.parseDouble(reader.readLine());
            k++;
            if (d-t<180) {
                list.add(d);
            }else{
                cnt += (list.size() * list.size()-1)/2;
                if (list.size()>0) {
                    t = list.remove(0);
                }else{
                    break;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            int j = i+1;
//            while(j<n&&d[j]-d[i]<180.0)j++;
//            cnt += (j - i - 1)*(j-i-2)/2;
//
//        }
        System.out.println(cnt);

    }
}
