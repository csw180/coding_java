package pgmers.pg68935;

public class Solution {

    // String toBase3(int dec) {
    //     StringBuilder sb  = new StringBuilder();
    //     int div = dec;
    //     while (div > 0) {
    //         int rem = div % 3;
    //         div  /= 3;
    //         sb.insert(0,String.valueOf(rem));
    //     }
    //     return sb.toString();
    // }

    // int toDecimal(int base, String baseStr) {
    //     int n = 0;
    //     int decimal = 0;
    //     for (int i=baseStr.length()-1; i >= 0 ; i--) {
    //         decimal += Character.getNumericValue(baseStr.charAt(i)) * (int)Math.pow(base,n);
    //         n++;
    //     }
    //     return decimal;
    // }

    // String reverseString(String s) {
    //     StringBuilder sb = new StringBuilder(s);
    //     return sb.reverse().toString();
    // }

    // public int solution(int n) {
    //     return toDecimal(3,reverseString(toBase3(n)));
    // }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 3;
            n  /= 3;
            sb.append(rem);
        }
        return Integer.parseInt(sb.toString(),3);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(45));
        System.out.println(s.solution(125));
    }
}
