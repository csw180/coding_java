package pgmers.pg17687;

public class Solution {
    
    String toBaseN(int num, int base) {
        String digits = "0123456789ABCDEF";
        if  (num==0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, digits.charAt(num % base));
            num  /= base;
        }
        return sb.toString();
    }

    public String solution(int n,int t,int m,int p) {
        StringBuilder answer = new StringBuilder();
        int start = 0;
        StringBuilder sb  = new StringBuilder();
        while (true) {
            sb.append(toBaseN(start, n));
            if (sb.length() > t * m) break;
            start ++;
        }
        String mergedString = sb.toString();
        for (int i=p-1; i<t*m; i+=m) {
            answer.append(mergedString.charAt(i));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2,4,2,1));
        System.out.println(s.solution(16,16,2,1));
        System.out.println(s.solution(16,16,2,2));
    }
}
