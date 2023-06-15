// 백준 숫자놀이:1679 https://www.acmicpc.net/problem/1679
package bj.bj1679; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    int playonDP(int n, int[] num_ary, int limit) {
        int[] DP  = new int[num_ary[n-1]*limit];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[1] = 1;
        int returnValue = 0;
        for (int i=2; i<DP.length; i++) {
            for (int num : num_ary) {
                if (i==num) {
                    DP[i] = 1;
                    break;
                }
                if (i<num) break;
                if (DP[i - num]+1 <= limit) 
                    DP[i] = Math.min(DP[i],DP[i - num]+1);
                // System.out.println(i+" "+num+Arrays.toString(DP));
            }
            if (DP[i] == Integer.MAX_VALUE)  {
                returnValue = i;
                break;
            }
        }
        return returnValue;
    } 

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            String[] str_ary = br.readLine().split(" ");
            int[] num_ary = Arrays.stream(str_ary).mapToInt(Integer::parseInt).toArray();
            int limit = Integer.parseInt(br.readLine());
            Main main  = new Main();
            int answer = main.playonDP(n,num_ary, limit);
            if (answer%2==0)
                bw.write("holsoon win at "+answer+"\n");
            else
                bw.write("jjaksoon win at "+answer+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
