// 백준 효율적인해킹(1325) https://www.acmicpc.net/problem/1325
// 시간초과

package bj.bj1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int dfs(int comNo, List<List<Integer>> coms, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(comNo);
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        visited[comNo] = true;
        int count = 0;
        while(queue.size() > 0) {
            int cur = queue.poll();
            visited[cur] = true;
            count ++;
            for(int next : coms.get(cur)) {
                if(!visited[next]) {
                    queue.add(next);
                }
            }
        }
        return count-1;
    } 

    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line," ");
            int n  = Integer.parseInt(st.nextToken());
            int m  = Integer.parseInt(st.nextToken());
            List<List<Integer>> coms = new ArrayList<>();
            for(int i=0; i<n+1; i++) {
                List<Integer> trusts = new ArrayList<>();
                coms.add(trusts);
            }

            for(int i=0 ; i< m; i++) {
                line = br.readLine();
                st = new StringTokenizer(line," ");
                int frm  = Integer.parseInt(st.nextToken());
                int to   = Integer.parseInt(st.nextToken());
                coms.get(to).add(frm);
            }
            // coms.stream().forEach( System.out::println );

            int max = 0;
            int[] results = new int[n+1];

            for(int i=1; i<n+1; i++) {
                if  (coms.get(i).size() == 0) {
                    continue;
                }
                int count = Main.dfs(i, coms, n);
                results[i] = count;
                if  (count > max) {
                    max = count;
                }
                // System.out.println(i + ":" + count);
            }

            List<String> result = new ArrayList<>();
            for(int i=1; i<n+1; i++) {
                if  (results[i] == max) {
                    result.add(String.valueOf(i));
                }
            }
            bw.write(String.join(" ",result)+"\n");
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
