package pgmers.pg12926;

public class Solution {
    public String solution(String s, int n) {
        int ord_A = (int)'A';
        int ord_Z = (int)'Z';
        int ord_a = (int)'a';
        int ord_z = (int)'z';

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            int ascii_no  = (int)s.charAt(i);
            char result  =  0;
            if  (ascii_no >= ord_A && ascii_no <= ord_Z) {
                if  (ascii_no + n > ord_Z) 
                     result =  (char) (ascii_no + n - 26);
                else result = (char) (ascii_no + n);
            } else if (ascii_no >= ord_a && ascii_no <= ord_z) {
                if  (ascii_no + n > ord_z) 
                     result =  (char) (ascii_no + n - 26);
                else result = (char) (ascii_no + n);
            } else {
                result = ' ';
            }
            sb.append(result);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AB", 1));
        System.out.println(s.solution("z", 1));
        System.out.println(s.solution("a B z", 4));
    }
}
