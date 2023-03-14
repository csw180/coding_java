package pgmers.pg12916;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;

        for ( int i =0; i<s.length(); i++) {
            if  ((s.charAt(i) == 'p') || (s.charAt(i) == 'P')) {
                pCount ++;
            } else if  ((s.charAt(i) == 'y') || (s.charAt(i) == 'Y'))  {
                yCount ++;
            }
        }
        if ((pCount==0 && yCount==0) || (pCount == yCount)) answer = true;
        else answer = false;

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("pPoooyY"));
        System.out.println(s.solution("Pyy"));
    }
}
