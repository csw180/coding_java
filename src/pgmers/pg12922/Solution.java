package pgmers.pg12922;

public class Solution {
    public String solution(int n) {
        String subak = "수박";
        StringBuilder answer = new StringBuilder();
        int div = n / 2;
        int rem = n % 2;
        for (int i=0;i<div;i++) answer.append(subak);
        if (rem==1) answer.append(subak.charAt(0));

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
    }
}
