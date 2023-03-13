package pgmers.pg42576;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String s : participant)
            hash.put(s,hash.getOrDefault(s,0) + 1);

        for (String c : completion)
            if (hash.get(c)==1)
                hash.remove(c);
            else
                hash.put(c,hash.get(c) - 1);
        Object[] keyArray =  hash.keySet().toArray();
        return (String)keyArray[0];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] param1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] param2 = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(s.solution(param1, param2));
    }
}
