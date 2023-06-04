// 프로그래머스 Summer/Winter Coding(~2018) > 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

package pgmers.pg49994;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class MoveLog {
    List<List<Integer>> moveList = new ArrayList<>();

    void add(int x1, int y1, int x2, int y2) {
        List<Integer> move = new ArrayList<>();
        move.addAll(Arrays.asList(x1, y1, x2, y2));
        // System.out.println("add: " + move);
        moveList.add(move);
        move = new ArrayList<>();
        move.addAll(Arrays.asList(x2, y2, x1, y1));
        // System.out.println("add: " + move);
        moveList.add(move);
    }

    boolean exist(int x1, int y1, int x2, int y2) {
        List<Integer> move = new ArrayList<>();
        move.addAll(Arrays.asList(x1, y1, x2, y2));
        if (moveList.contains(move)) 
            return true;
        else 
            return false;
    }
}

public class Solution {
    public int solution(String dirs) {
        int moveCount = 0;
        int curX = 0, curY = 0; 
        int tempCurX = curX, tempCurY = curY;
        MoveLog moveLog = new MoveLog();
        for (int i = 0; i < dirs.length(); i++) {
            String dir = dirs.substring(i, i+1);
            boolean isMoved = false;
            switch (dir) {
                case "L":
                    if  (curX > -5) {
                        curX--;
                        isMoved = true;
                    }
                    break;
                case "R":
                    if  (curX < 5) {
                        curX++;
                        isMoved = true;
                    }
                    break;
                case "U":
                    if  (curY < 5) {
                        curY++;
                        isMoved = true;
                    }
                    break;
                case "D":
                    if  (curY > -5) {
                        curY--;
                        isMoved = true;
                    }
                    break;                
            }
            // System.out.println(dir + " " + tempCurX + " " + tempCurY + " " + curX + " " +curY);
            if (isMoved)  {
                if (!moveLog.exist(tempCurX, tempCurY, curX, curY)) {
                    moveCount++;
                    moveLog.add(tempCurX, tempCurY,curX, curY);
                }
                tempCurX = curX;
                tempCurY = curY;
            }
        }
        return moveCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ULURRDLLU")); 
        System.out.println(solution.solution("LULLLLLLU")); 
    }
}
