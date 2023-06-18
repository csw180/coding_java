// 백준 음식물피하기: 1743 https://www.acmicpc.net/problem/1743
package bj.bj1743;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    int bfs(int r, int c, int[][] map, boolean[][] visited) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(r,c));
        int[][] rcx = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        while(!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            r = list.get(0);
            c = list.get(1);
            if (visited[r][c] == true)
                continue;
            visited[r][c] = true;
            count ++;
            for(int i=0; i < 4; i++) {
                int nr = r + rcx[i][0];
                int nc = c + rcx[i][1];
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || visited[nr][nc] == true || map[nr][nc] == 0) {
                    continue;
                }
                queue.offer(Arrays.asList(nr,nc));
            }
        }
        return count;
    } 
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        Main main = new Main();
        try {
            int[] nmk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int[][] map = new int[nmk[0]][nmk[1]];
            boolean[][] visited = new boolean[nmk[0]][nmk[1]];
            
            for(int i=0; i < nmk[2]; i++) {
                String[] rc = br.readLine().split(" ");
                map[Integer.parseInt(rc[0])-1][Integer.parseInt(rc[1])-1] = 1;
            }

            int maxCount = 0;
            for(int i=0; i < nmk[0]; i++) {
                for(int j=0; j < nmk[1]; j++) {
                    if  (visited[i][j] == false && map[i][j] == 1) {
                        maxCount = Math.max(maxCount, main.bfs(i,j,map,visited));
                    }
                    // System.out.print(map[i][j]+" ");
                }
                // System.out.println("\n");
            }
            bw.write(maxCount+"");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
