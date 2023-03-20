package bj.bj15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Permutation {

    int[] arr;
    int n;     // 전체원소갯수
    int m;     // 선택원소갯수
    List<String> results;

    Permutation(int[] arr, int m) {
        this.arr = arr;
        this.results = new ArrayList<String>();
        n = arr.length;
        this.m = m;
    }

    List<String> getResult() {
        int[] result = new int[m];
        boolean[] visit = new boolean[n];
        recursive(result,visit,0);
        return results;
    }

    // 같은수를 여러번 골라도 된다
    // 고른 수열은 비내림차순이어야 한다.
    private void recursive(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int r : result) sb.append(r).append(' ');
            this.results.add(sb.toString().trim());
            return;
        }
        for (int i=0;i<n;i++) {
            if (depth==0 || result[depth-1] <= arr[i]) {
                result[depth] = arr[i];
                recursive(result, visit,depth+1);
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
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i+1;
            }

            List<String> result = new Permutation(arr, M).getResult();
            for (String string : result) {
                bw.write(string+"\n");
            }
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
