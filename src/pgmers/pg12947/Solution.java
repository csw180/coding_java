package pgmers.pg12947;

public class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int xx = x;
        int sum = 0;
        while (xx > 0) {
            sum += xx % 10;
            xx = xx / 10;
        }
        if (x % sum == 0) answer = true;
        else answer = false;
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
        System.out.println(s.solution(12));
        System.out.println(s.solution(11));
        System.out.println(s.solution(13));
    }
}
