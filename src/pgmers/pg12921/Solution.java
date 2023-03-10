package pgmers.pg12921;

public class Solution {

    /**
     * @param n
     * @return 소수의 갯수
     */
    public int solution(int n) {
        int primes = 0;
        for (int i=2;i<=n;i++) {
            boolean isprime = true;
            for(int j=2;j<(int)(Math.sqrt(i)+1);j++) {
                if (i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) primes ++;
        }
        return primes;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
        System.out.println(s.solution(5));
    }
}
