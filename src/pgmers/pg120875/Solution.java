package pgmers.pg120875;
// import java.util.Arrays;

public class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int[][] cases = new int[][] {{0,1,2,3},{0,2,1,3},{0,3,1,2}};
        for (int i=0; i<3; i++) {
            int[] p1 = dots[cases[i][0]];
            int[] p2 = dots[cases[i][1]];
            int[] p3 = dots[cases[i][2]];
            int[] p4 = dots[cases[i][3]];
            if  ((p1[1]-p2[1]) * (p3[0]-p4[0]) ==  (p1[0]-p2[0]) * (p3[1]-p4[1])) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}
