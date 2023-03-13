package pgmers.pg12982;

import java.util.Arrays;

public class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt = 0;
        int sum = 0;
        for (int v : d) {
            cnt++;
            sum += v;
            if (sum > budget) return cnt-1;
        }
        return d.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] param1 = {1,3,2,5,4};
        int param2 = 9;
        System.out.println(s.solution(param1,param2));
    }
}
