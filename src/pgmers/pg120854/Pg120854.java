package pgmers.pg120854;
import java.util.Arrays;

public class Pg120854 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] p = new String[] {"We", "are", "the", "world!"};
        System.out.println(Arrays.toString(s.solution(p)));

        p = new String[] {"I", "Love", "Programmers."};
        System.out.println(Arrays.toString(s.solution(p)));
    }
}
