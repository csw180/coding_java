package pgmers.pg42577;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> hash  = new HashMap<>();
        for (String p : phone_book) {
            hash.put(p, hash.getOrDefault(p, 0)+1);
        }

        for (String p : phone_book) {
            for (int i=1; i<p.length(); i++) {
                if  (hash.containsKey(p.substring(0, i)))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] param ={"119", "97674223", "1195524421"};
        System.out.println(s.solution(param));
        param = new String[] {"123","456","789"};
        System.out.println(s.solution(param));
        param = new String[] {"12","123","1235","567","88"};
        System.out.println(s.solution(param));        
    }
}
