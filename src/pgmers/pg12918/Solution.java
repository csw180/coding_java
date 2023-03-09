package pgmers.pg12918;

public class Solution {

    public boolean solution(String s) {
        System.out.println(s.matches("^[0-9]*$"));
        if  ((s.length() == 4 || s.length() == 6) && (s.matches("^[0-9]*$"))) 
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("a234"));
        System.out.println(s.solution("1234"));

    }    
}
