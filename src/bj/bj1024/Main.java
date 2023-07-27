// 백준 수열의합:1024 https://www.acmicpc.net/problem/1024

package bj.bj1024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] answer = null;
            int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i=nl[1]; i<=100; i++) {
                double x =  ((nl[0] * 1.0) / i) - ((i - 1) / 2.0);
                if  (x >= 0 & x==(int)x) {
                    answer = new int[i];
                    int  j = 0;
                    while (j < i) {
                        answer[j] = (int)x + j;
                        j++;
                    }
                    break;
                }
            }
            if (answer == null) {
                bw.write(-1+"\n");
            } else {
                String[] strAnswer = Arrays.stream(answer).mapToObj(String::valueOf).toArray(String[]::new);
                bw.write(String.join(" ", strAnswer)+"\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
