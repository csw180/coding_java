/*
백준 추월:2002 https://www.acmicpc.net/problem/2002
출구에서 나온 차량의 순서대로 입구진입 등수를 조사해본다.
출구에서 나온차량은 뒤따라 나온 차량과 비교했을때 입구진입 등수가 앞서야 한다
만약 뒤 따라 나온 차량중에 입구진입등수가 자신보다 앞서는 차가 있다면 앞지르기를 했다고 볼수 있다
 */
package bj.bj2002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> entryOrderHashMap  = new HashMap<>();
            for (int i=0; i< N; i++) {
                entryOrderHashMap.put(br.readLine(), i);
            }

            int[] exitOrderArray = new int[N];
            for (int i=0; i< N; i++) {
                exitOrderArray[i] = entryOrderHashMap.get(br.readLine());
            }

            int minValue = Integer.MAX_VALUE;
            int[] minValueArray = new int[N];
            for (int i=N-1; i>=0; i--) {
                minValueArray[i] = Math.min(minValue,exitOrderArray[i]);
                minValue = minValueArray[i];
            }
            // System.out.println(Arrays.toString(exitOrderArray));
            // System.out.println(Arrays.toString(minValueArray));

            for (int i=0; i< N; i++) {
                if (exitOrderArray[i] > minValueArray[i]) answer++;
            }
            bw.write(answer+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
