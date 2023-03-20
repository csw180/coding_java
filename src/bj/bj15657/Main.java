package bj.bj15657;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Permutation 완결
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
        recursive_incself_notdesc(result,visit,0);
        return results;
    }

    // 중복없이 M 개를 고른 수열
    private void recursive_basic(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int r : result) sb.append(r).append(' ');
            this.results.add(sb.toString().trim());
            return;
        }
        
        for (int i=0;i<n;i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                recursive_basic(result, visit,depth+1);
                visit[i] = false;
            }
        }
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
                result[depth] = arr[i];
                recursive_asc(result, visit,depth+1);
            }
        }
    }

    // 같은수를 여러번 골라도 된다
    private void recursive_incself(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int r : result) sb.append(r).append(' ');
            this.results.add(sb.toString().trim());
            return;
        }
        for (int i=0;i<n;i++) {
                result[depth] = arr[i];
                recursive_incself(result, visit,depth+1);
        }
    }

    // 같은수를 여러번 골라도 된다
    // 수열은 비내림차순
    private void recursive_incself_notdesc(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int r : result) sb.append(r).append(' ');
            this.results.add(sb.toString().trim());
            return;
        }
        for (int i=0;i<n;i++) {
            if (depth==0 || result[depth-1] <= arr[i]) {
                result[depth] = arr[i];
                recursive_incself_notdesc(result, visit,depth+1);
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
            line = br.readLine();
            tokens = new StringTokenizer(line);

            int[] arr = new int[N];
            int arrIdx =  0;
            while (tokens.hasMoreElements()) {
                arr[arrIdx] = Integer.parseInt(tokens.nextToken());
                arrIdx ++;
            }
            Arrays.sort(arr);

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
