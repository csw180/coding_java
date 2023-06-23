// Permutation class 에 각 결과를 처리하는 Consumer 받아서 일임하는 형태로 수정해봄

package bj.bj1821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

class Permutation2 {
    int n;              // 1~ n 까지 숫자중
    int size;          // 몇개를 뽑을것인가
    int[] footprint;  // 뽑혀진 값들을 모아둔다..
    int[] visited;
    Consumer<int[]> consumer;

    Permutation2(int n, int size, Consumer<int[]> consumer) {
        this.n = n;
        this.size = size;
        this.consumer = consumer;
        visited = new int[n+1];
        footprint = new int[size];
    }

    void dfs(int step) {
        if (step == size) {
            consumer.accept(footprint);
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

    void perform() {
        dfs(0);
    }
}

public class Main2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int[] nf = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Consumer<int[]> consumer = (nums) -> {
                System.out.println(Arrays.toString(nums));
            };

            Permutation2 permutation2 = new Permutation2(nf[0], nf[0], consumer);
            permutation2.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
