package pgmers.pg12943;

public class Solution {

    long collatz(long n) {
        if (n%2==0) return n/2;
        else return (n*3)+1;
    }
    public int solution(int num) {
        int count = 0;
        long lnum = num;
        while (lnum > 1 && count <= 500) {
            count++;
            lnum = collatz(lnum);
            // System.out.println(count+":"+lnum);
        }
        return (count > 500) ? -1 : count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6));
        System.out.println(s.solution(16));
        System.out.println(s.solution(626331));
    }
}
