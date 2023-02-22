package pgmers.pg120854;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] strlist) {
        List<Integer> result = new ArrayList<>();

        for (String s : strlist) {
            result.add(Integer.valueOf(s.length()));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}