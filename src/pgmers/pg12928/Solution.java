package pgmers.pg12928;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> divisor(int n) {
        List<Integer> result  = new ArrayList<>();
        for ( int i = 1; i < (int)Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != n/i) result.add(n/i);
            }
        }
        return result;
    }

    public int solution(int n) {
        List<Integer> result = divisor(n);
        int sum  = result.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(12));
        System.out.println(s.solution(5));
    }
}
