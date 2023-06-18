// 백준 숨바꼭질(1697) https://www.acmicpc.net/problem/1697

package bj.bj1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    int bfs(int s,int e, boolean[] visit) {
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> newList = Arrays.asList(s,0);
        int result = 0;
        q.offer(newList);
        while (!q.isEmpty()) {
            List<Integer> polledList = q.poll();
            int x = polledList.get(0);
            int count = polledList.get(1);
            if  (x == e) {
                result = count;
                break;
            }
            if  (visit[x])  continue;
            visit[x] = true;
            if  (x+1 <= 100000 && !visit[x+1]) {
                newList = Arrays.asList(x+1,count+1);
                q.offer(newList);
            }
            if  (x-1 >= 0 && !visit[x-1]) {
                newList = Arrays.asList(x-1,count+1);
                q.offer(newList);
            }
            if  (x*2 <= 100000 && !visit[x*2]) {
                newList = Arrays.asList(x*2,count+1);
                q.offer(newList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String[] nk = br.readLine().split(" ");
            int n  = Integer.parseInt(nk[0]);
            int k  = Integer.parseInt(nk[1]);
            boolean[] visit = new boolean[100001];
            Main m = new Main();
            int result = m.bfs(n,k,visit);
            bw.write(result+"\n");
            bw.flush();
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
