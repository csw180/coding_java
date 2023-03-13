package pgmers.pg17682;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int solution(String dartResult) {
        int[] scores = {0,0,0};
        int score_idx  = 0;
        Pattern pattern  = Pattern.compile("[0-9]+[SDT]+[*#]*");
        Matcher matcher = pattern.matcher(dartResult);

        Pattern scorePattern = Pattern.compile("[0-9]+");
        Pattern bonusPattern = Pattern.compile("[SDT]+");
        Pattern optionPattern = Pattern.compile("[*#]+");

        while (matcher.find()) {
            int score = 0;
            String bonus = null;
            String option = null;
            try {
                Matcher scoreMatcher = scorePattern.matcher(matcher.group());
                if  (scoreMatcher.find())
                    score =  Integer.parseInt(scoreMatcher.group());

                Matcher bonusMatcher = bonusPattern.matcher(matcher.group());
                if  (bonusMatcher.find())
                    bonus = bonusMatcher.group();

                Matcher optionMatcher = optionPattern.matcher(matcher.group());
                if   (optionMatcher.find())
                    option = optionMatcher.group();

            } catch (IllegalStateException e) {}

            // System.out.println(score);
            // System.out.println(bonus);
            // System.out.println(option);

            scores[score_idx] = score;
            if  (bonus.equals("D")) {
                scores[score_idx] = scores[score_idx] * scores[score_idx];
            } else if (bonus.equals("T")) {
                scores[score_idx] = scores[score_idx] * scores[score_idx] * scores[score_idx];
            }

            if  (option != null)  {
                if  (option.equals("*")) {
                    scores[score_idx] *= 2;
                    if (score_idx > 0) scores[score_idx - 1] *= 2;
                } else if (option.equals("#")) {
                    scores[score_idx] *= -1;
                }
            }
            score_idx++;
        }

        int sum = Arrays.stream(scores).sum();
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String param = "1D2S#10S";
        System.out.println(s.solution(param));

    }
}
