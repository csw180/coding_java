// 프로그래머서 삼각달팽이 (https://school.programmers.co.kr/tryouts/71848/challenges)

package pgmers.pg71848;

import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<Integer> doSumOfRow(int[][] sumOfRow
                    ,int row           
                    ,int col
                    ,int startNum           // 시작숫자
                    ,int count              // 이동 갯수
                    ,int direction) {       // 이동방향(0:down,1:fix,2:up)

        sumOfRow[row-1][col-1] += startNum;
        for (int i = startNum+1 ;i< startNum + count; i++ ) {
            if (direction == 0)  {
                row++;
            } else if (direction == 2)  {
                row--;
                col--;
            } else if (direction == 1)  {
                col++;
            }
            sumOfRow[row-1][col-1] += i;
        }
        return Arrays.asList(row,col,startNum+count-1);
    }

    public int[] solution(int n) {
        int[] answer = new int[((n+1)*n)/2];
        int[][] sumOfRow = new int[n][n];

        int startNum = 1;
        int row = 1;
        int col = 1;

        for (int i=n; i>0; i--) {
            int direction = (n-i)%3;
            if (i<n) {
                if (direction == 0)  {
                    row++;
                } else if (direction == 2)  {
                    row--;
                    col--;
                } else if (direction == 1)  {
                    col++;
                }
                startNum++;
            }
            List<Integer> returnList = doSumOfRow(sumOfRow, row, col, startNum, i, direction );
            row = returnList.get(0);
            col = returnList.get(1);
            startNum = returnList.get(2);
            // System.out.println(row + "," + col+","+startNum);
        }

        int answer_idx = 0;
        for (int i=0; i< n; i++)  {
            for  (int j=0; j< n; j++) {
                // System.out.print(sumOfRow[i][j] + " ");
                if  (sumOfRow[i][j] != 0) {
                    answer[answer_idx] = sumOfRow[i][j];
                    answer_idx++;
                }
            }
            // System.out.print("\n");
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5))); 
    }
}
