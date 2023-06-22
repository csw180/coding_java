// 백준 수들의 합6 : 1821 https://www.acmicpc.net/problem/1821

package bj.bj1821;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Permutation {
    int n;              // 1~ n 까지 숫자중
    int size;          // 몇개를 뽑을것인가
    int[] footprint;  // 뽑혀진 값들을 모아둔다..
    int m;            // pyramidSum 값이 m 과 같은것을 답으로 
    int[] visited;
    String[] result;  
    boolean founded;  // 조건에 맞는 첫번째 건이 발견되면 즉시 재귀를 빠져나오기 위해서 사용

    Permutation(int n, int size, int m) {
        this.n = n;
        this.m = m;
        this.size = size;
        visited = new int[n+1];
        founded = false;
        footprint = new int[size];
    }

    void dfs(int step) {
        if (founded)  return;

        if (step == size) {
            if (footprint.length > 0 && m == pyramidSum(footprint)) {
                result = Arrays.stream(footprint)
                    .mapToObj(x -> String.valueOf(x))
                    .toArray(String[]::new);
                founded = true;
            }
            return;
        }
        
        for(int i = 1; i < n+1; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                footprint[step] = i;
                dfs(step+1);
                footprint[step] = 0;
                visited[i] = 0;
            }
        }
    }

    String[] perform() {
        dfs(0);
        return result;
    }

    int pyramidSum(int[] nums) {
        int[] localNums = Arrays.copyOf(nums, nums.length);

        while(localNums.length > 1) {   
            int[] tempNums = new int[localNums.length-1];
            for(int i =1; i< localNums.length; i++) {
                tempNums[i-1] = localNums[i]+localNums[i-1];
            }
            localNums = tempNums;
        }
        return localNums[0];
    }
}

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] nf = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            Permutation permutation = new Permutation(nf[0], nf[0], nf[1]);
            bw.write(String.join(" ", permutation.perform()));
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
