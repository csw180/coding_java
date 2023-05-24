package pgmers.pg71847;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public String[] solution(int[][] line) {
        int n = line.length;

        List<List<Integer>> meets = new ArrayList<>();
        Integer[] x_minmax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        Integer[] y_minmax = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int mom = line[i][0]*line[j][1] - line[i][1]*line[j][0];
                int x_child = line[i][1]*line[j][2] - line[i][2]*line[j][1];
                int y_child = line[i][2]*line[j][0] - line[i][0]*line[j][2]; 
                if  ((mom==0)  || // 분모가 0인경우
                    (x_child % mom !=0 || y_child % mom !=0))  // 분자나누기 분모가 정수가 아닌경우
                    continue;
                List<Integer> meet = new ArrayList<>();
                Integer x = x_child/mom;
                Integer y = y_child/mom;
                if (x < x_minmax[0]) x_minmax[0] = x;
                if (x > x_minmax[1]) x_minmax[1] = x;
                if (y < y_minmax[0]) y_minmax[0] = y;
                if (y > y_minmax[1]) y_minmax[1] = y;

                meet.add(x_child/mom);
                meet.add(y_child/mom);

                meets.add(meet);
            }
        }
        // meets.stream().forEach(
        //     x -> System.out.println(x.toString())
        // );
        // System.out.println(Arrays.toString(x_minmax));
        // System.out.println(Arrays.toString(y_minmax));

        List<String> result = new ArrayList<>();
        for (int i = y_minmax[1]; i>= y_minmax[0]; i--) {
            String asta = "";
            for (int j = x_minmax[0]; j <= x_minmax[1]; j++) {
                List<Integer> key = new ArrayList<>();
                key.add(j);
                key.add(i);
                if (meets.indexOf(key) >= 0 ) {
                    asta += "*";
                } else {
                    asta +=  ".";
                }  

            }
            result.add(asta);
        }
        return result.toArray(new String[result.size()]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}})));
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, -1, 0}, {2, -1, 0}})));
    }
}
