// 백준 미로탐색:2178 https://www.acmicpc.net/problem/2178
// dfs, bfs 모두 가능하나 최소이동객수를 구하는것이므로 bfs 가 적당함
// dfs는 완전탐색해야 최소이동갯수를 구할수 있는 반면에 bfs는 목적지에 도달하기만
// 하면 즉시 종료할 수 있다
// bfs 구현시 visted 배열을 만들어 방문한곳은 또 방문하지 않게 하는게 일반적이나
// 원본 배열에 배열한 횟수대로 갱신시켜 나가는 방법으로 구현했으므로 
// 방문순서를 2,3,4,.. 로 2부터 시작하도록 하고(원본배열에서 1을 사용하고 있어서)
// 나중에 최종방문순서를 1을 빼서 사용하도록 함
// Point 클래스에 방문순서 step 을 멤버로 넣어서 하면 간단한데 ..메모리 초과 걸림

package bj.bj2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

final class Point {
    public final int r;
    public final int c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Point [r=" + r + ", c=" + c;
    }
    
}

class BfsHelper {
    int[][] maze;
    Queue<Point> queue;
    int steps;
    int h, w;

    public BfsHelper(int[][] maze) {
        this.maze = maze;
        this.h = maze.length;
        this.w =  maze[0].length;
    }

    void bfs() {
        queue = new LinkedList<>();
        queue.add(new Point(0,0));
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        maze[0][0]  = 2;

        while ( !queue.isEmpty()) {
            Point p = queue.poll();
            steps = maze[p.r][p.c];
            
            if  (p.r==maze.length-1 && p.c== maze[0].length-1) break;
            
            steps++;
            for (int i = 0; i < 4; i++) {
                if (p.r + dx[i] >=0 && p.r + dx[i] < h && 
                    p.c + dy[i] >=0 && p.c + dy[i] < w &&
                    maze[p.r + dx[i]][p.c + dy[i]] == 1)   {
                        queue.add(new Point(p.r + dx[i],p.c + dy[i]));
                        maze[p.r + dx[i]][p.c + dy[i]] = steps;
                    }
            }
        }
    }

    int getSteps() {
        return steps-1;
    }
}

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[]  nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int[][] maze = new int[nm[0]][];
            for(int i = 0; i < nm[0]; i++) {
                maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            BfsHelper bfsHelper = new BfsHelper(maze);
            bfsHelper.bfs();
            bw.write(bfsHelper.getSteps()+"");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
