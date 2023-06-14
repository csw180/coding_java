// 백준 캡틴 이다솜:1660 https://www.acmicpc.net/problem/1660

package bj.bj1660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    int[] cumballs(int limit) {
        int cum = 0;
        int i  = 1;
        List<Integer> cumlist  = new ArrayList<>();
        
        while (cum < limit) {
            cum += (i+1) * i / 2;
            cumlist.add(cum);
            i++;
        }
        return cumlist.stream()
            .mapToInt(e -> e.intValue())
            .toArray();
    }

    int[] runDP(int n, int[] cumballs) {
        int[] dp  = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 1; i < n+1; i++ ) {
            for (int j : cumballs) {
                if  (i==j) {
                    dp[i] = 1;
                    break;
                } else if (i < j) {
                    break;
                } 
                dp[i] = Math.min(dp[i], dp[i-j]+1);
            }
        }
        return dp;

    }
    public static void main(String[] args) {
        Main main   = new Main();
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] cumballs =  main.cumballs(n);
            int[] dp = main.runDP(n,cumballs);
            // System.out.println(Arrays.toString(dp));
            bw.write(dp[n]+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
