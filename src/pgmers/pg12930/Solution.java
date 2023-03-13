package pgmers.pg12930;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx =-1;

        for (int i=0; i<s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) idx++;
            else idx=-1;

            if (idx==-1) 
                sb.append(" ");
            else if (idx % 2 == 0)
                sb.append(Character.toUpperCase(s.charAt(i)));
            else 
                sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String param1 = "try hello world";
        Solution s= new Solution();
        System.out.println(s.solution(param1));
    }
}