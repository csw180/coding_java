package pgmers.pg169198;

import java.util.Arrays;

public class Solution {
    
    int distince(int x1,int y1,int x2,int y2) {
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] result = new int[balls.length];
        int resultIdx = 0;
        for (int[] is : balls) {
            int minValue = Integer.MAX_VALUE;
            int ballX = is[0];
            int ballY = is[1];
            if (!(startY == ballY && startX > ballX))
                minValue = Math.min(minValue, distince(startX, startY, -ballX, ballY)); // 왼쪽
            if (!(startY == ballY && startX < ballX))
                minValue = Math.min(minValue, distince(-(m-startX), startY, m-ballX, ballY)); // 오늘쪽
            if (!(startX == ballX && startY < ballY))
                minValue = Math.min(minValue, distince(startX, -(n-startY), ballX, n-ballY)); // 위쪽        
            if (!(startX == ballX && startY > ballY))
                minValue = Math.min(minValue, distince(startX, startY, ballX, -ballY)); // 아래쪽
            if (startX * ballY == startY * ballX  && startX < ballX) {
                minValue = Math.min(minValue,distince(startX, startY, -ballX,-ballY)); // 좌측아랫모서리
                minValue = Math.min(minValue,distince(startX, -(n-startY), -ballX,n-ballY)); // 좌측윗모서리
            }
            if (startX * ballY == startY * ballX && startX > ballX) {
                minValue =  Math.min(minValue,distince(-(m-startX), startY, m-ballX,-ballY)); // 우측아랫모서리
                minValue =  Math.min(minValue,distince(-(m-startX), -(n-startY), m-ballX,n-ballY)); // 우측윗모서리                
            }
            result[resultIdx] = minValue;
            resultIdx ++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] param = {{7, 7}, {2, 7}, {7, 3}};
        System.out.println(Arrays.toString(s.solution(10,10,3,7,param)));
    }
}
