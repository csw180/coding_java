package pgmers.pg181943;

public class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder(my_string.substring(0, s));
        sb.append(overwrite_string);
        sb.append(my_string.substring(s+overwrite_string.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        String param1 = "Program29b8UYP";
        String param2 = "merS123";

        System.out.println(solution.solution(param1, param2, 7));
    }
}