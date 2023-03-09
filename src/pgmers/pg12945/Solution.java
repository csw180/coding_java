package pgmers.pg12945;

public class Solution {

    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n] % 1234567;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
        System.out.println(s.solution(5));
        System.out.println(s.solution(47));
        System.out.println(s.solution(1500));
        System.out.println(s.solution(100000));
    }
}
