package pgmers.pg42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] pattn1 = {1,2,3,4,5};
        int[] pattn2 = {2,1,2,3,2,4,2,5};
        int[] pattn3 = {3,3,1,1,2,2,4,4,5,5};
        int[] scores = {0,0,0};

        int max_value = 0;
        for(int i = 0 ; i < answers.length; i++) {
            if (answers[i] == pattn1[i%pattn1.length] )
                scores[0] += 1;
            if (answers[i] == pattn2[i%pattn2.length] )
                scores[1] += 1;                
            if (answers[i] == pattn3[i%pattn3.length] )
                scores[2] += 1;  

            max_value = Math.max(scores[0],Math.max(scores[1],scores[2]));
        }
        List<Integer> answer_list  = new ArrayList<Integer>();        
        for (int i=0 ; i < scores.length; i++) {
            if (scores[i] == max_value)
                answer_list.add(i+1);
        }
        // answer_list.stream().mapToInt(Integer::intValue).toArray();
        // stream 보다 빠르다.
        int[] answer = new int[answer_list.size()];
        for (int i = 0; i < answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        // int[] param = new int[] {1,2,3,4,5};
        int[] param = new int[] {1,3,2,4,2};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(param)));
    }


}
