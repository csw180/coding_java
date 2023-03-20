// https://www.acmicpc.net/problem/18290
// 틀림 ㅠㅠ 
package bj.bj18290;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Permutation 완결
class Permutation {

    int[] arr;
    int n;     // 전체원소갯수
    int m;     // 선택원소갯수
    List<String> results;
    int r;
    int c;

    Permutation(int[] arr, int m,int r,int c) {
        this.arr = arr;
        this.results = new ArrayList<String>();
        n = arr.length;
        this.m = m;
        this.r = r;
        this.c = c;
    }

    List<String> getResult() {
        int[] result = new int[m];
        boolean[] visit = new boolean[n];
        recursive_asc(result,visit,0);
        return results;
    }

    // 중복없이 M 개를 고른 수열
    // 수열은 오름차순
    private void recursive_asc(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int r : result) sb.append(r).append(' ');
            this.results.add(sb.toString().trim());
            return;
        }

        for (int i=0;i<n;i++) {
            if (depth==0 || result[depth-1] < arr[i]) {
                int mok = i / c;
                int rem = i % c;
                if  (mok-1 >= 0 && visit[(mok-1)*c+rem]) continue;
                if  (rem-1 >= 0 && visit[(mok*c)+rem-1]) continue;

                visit[i] = true;
                result[depth] = arr[i];
                recursive_asc(result, visit,depth+1);
                visit[i] = false;
            }
        }        
    }

}


public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String line = br.readLine();
            StringTokenizer tokens = new StringTokenizer(line);
            int N = Integer.parseInt(tokens.nextToken());
            int M = Integer.parseInt(tokens.nextToken());
            int K = Integer.parseInt(tokens.nextToken());
            int[] arr = new int[N*M];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }

            int[] board = new int[N*M];
            int boardIdx = 0;
            for (int i = 0; i < N ; i++) {
                line = br.readLine();
                tokens = new StringTokenizer(line);
                while (tokens.hasMoreElements()) {
                    board[boardIdx] = Integer.parseInt(tokens.nextToken());
                    boardIdx ++;
                }
            }

            List<String> result = new Permutation(arr, K, N, M).getResult();
            int maxValue = 0;
            for (String string : result) {
                // bw.write(string+"\n");
                StringTokenizer toc = new StringTokenizer(string);
                int subSum =  0;
                while (toc.hasMoreElements()) {
                    subSum += board[Integer.parseInt(toc.nextToken())];
                }
                maxValue =  Math.max(maxValue,subSum);
            }
            bw.write(maxValue+"\n");
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
