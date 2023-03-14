package pgmers.pg12915;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if  (o1.charAt(n) >  o2.charAt(n))
                    return 1;
                else if  (o1.charAt(n) < o2.charAt(n))
                    return -1;
                else return o1.compareTo(o2);
            }
            
        });
        return strings;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] param1 = {"sun", "bed", "car"};
        System.out.println(Arrays.toString(s.solution(param1,1)));

    }
}
