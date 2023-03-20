package pgmers.pg12953;

public class Solution {

    /**
     * @param a
     * @param b
     * @return int:최대공약수
     */
    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b,a % b);
    }

    /**
     * @param a
     * @param b
     * @return int:최소공배수
     */
    public static int lcm(int a, int b) {
        return (a*b) / gcd(a,b);
    }

    public int solution(int[] arr) {
        int prevLCM = arr[0];
        for (int i = 1 ; i < arr.length; i++) {
            prevLCM = lcm(prevLCM, arr[i]);
        }
        return prevLCM;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] param = {2,6,8,14};
        System.out.println(s.solution(param));    
        param = new int[] {1,2,3};
        System.out.println(s.solution(param));    
    }
}
