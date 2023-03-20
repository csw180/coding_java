package pgmers.pg169199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    String[] board = null;

    List<int[]> movable(int r, int c) {
        List<int[]> result = new ArrayList<>();
        int[] rc = null;

        //왼쪽
        int rr = r;
        int cc = c;
        while (cc > 0 && board[rr].charAt(cc-1) != 'D') cc --;
        if (c != cc) {
            rc = new int[] {rr,cc};
            result.add(rc);
        }

        //오른쪽
        rr = r;
        cc = c;
        while (cc < board[0].length()-1 && board[rr].charAt(cc+1) != 'D') cc ++;
        if (c != cc) {
            rc = new int[] {rr,cc};
            result.add(rc);
        }

        //위쪽
        rr = r;
        cc = c;
        while (rr > 0 && board[rr-1].charAt(cc) != 'D') rr --;
        if (r != rr) {
            rc = new int[] {rr,cc};
            result.add(rc);
        }

        //아래쪽
        rr = r;
        cc = c;
        while (rr < board.length-1 && board[rr+1].charAt(cc) != 'D') rr ++;
        if (r != rr) {
            rc = new int[] {rr,cc};
            result.add(rc);
        }
        return result;
    }

    int bfs(int r, int c) {
        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visit = new boolean[board.length][board[0].length()];
        for (boolean[] bs : visit) {
            Arrays.fill(bs, false);
        }
        List<Integer> e = new ArrayList<>(Arrays.asList(r,c,0));
        q.add(e);
        while (!q.isEmpty()) {
            e = q.poll();
            int pr = e.get(0);
            int pc = e.get(1);
            int cnt = e.get(2);
            if (board[pr].charAt(pc)=='G') return cnt;
            if (visit[pr][pc]) continue;
            visit[pr][pc] = true;
            List<int[]> result = movable(pr, pc);
            for (int[] v : result) {
                q.add(new ArrayList<>(Arrays.asList(v[0],v[1],cnt+1)));
            }
        }
        return -1;
    }

    public int solution(String[] board) {
        this.board = board;
        int rr=0,rc=0;
        for (int i=0 ; i< board.length; i++) {
            if (board[i].contains("R")) {
                rr = i;
                rc = board[i].indexOf('R');
                break;
            }
        }
        return bfs(rr,rc);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] param = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(s.solution(param));    
        param = new String[] {".D.R", "....", ".G..", "...D"};
        System.out.println(s.solution(param));    
    }
}
