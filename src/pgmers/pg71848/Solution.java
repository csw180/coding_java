package pgmers.pg71848;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void doSumOfRow(int[][] sumOfRow  // 각층의 숫자의 합산을 저장
                    ,int startRow           // 층이동할 시작층
                    ,int startColumn
                    ,int startNum           // 각 층에 합산할 시작숫자
                    ,int count              // 층이동 갯수
                    ,String direction) {    // 어느 방향으로 이동할것인가(down,up,fix)

        for (int i = startNum ;i< startNum + count; i++ ) {
            sumOfRow[startRow-1][startColumn-1] += i;
            if (direction.equals("down"))  {
                startRow++;
            } else if (direction.equals("up"))  {
                startRow--;
                startColumn--;
            } else if (direction.equals("fix"))  {
                startColumn++;
            }
        }
        // sumOfRow[startRow-1][startColumn-1] += startNum + count;
        return startRow;
    }

    public int[] solution(int n) {
        int[] answer = {};
        int[][] sumOfRow = new int[n][n];

        System.out.println( doSumOfRow(sumOfRow, 1, 1, 1, 5, "down"));
        System.out.println( doSumOfRow(sumOfRow, 5, 2, 6, 4, "fix") );
        System.out.println( doSumOfRow(sumOfRow, 4, 4, 10, 3, "up") );
        System.out.println( doSumOfRow(sumOfRow, 3, 2, 13, 2, "down") );
        System.out.println( doSumOfRow(sumOfRow, 4, 3, 15, 1, "fix") );

        for (int i=0; i< n; i++)  {
            for  (int j=0; j< n; j++)
                System.out.print(sumOfRow[i][j] + " ");
            System.out.print("\n");
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5);
    }
}
