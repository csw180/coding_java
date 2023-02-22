package pgmers.pg120956;

public class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            String result = s.replaceAll("aya|ye|woo|ma","");
            if (result.length() == 0) answer++;
        }
        return answer;
    }
}
