// 프로그래머스 Summer/Winter Coding(~2018)>스킬트리 : 49993
// https://school.programmers.co.kr/learn/courses/30/lessons/49993

package pgmers.pg49993;

import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        for (String skillTree : skillTrees) {
            Stack<String> stack = new Stack<>();
            List<String> revSkill = Arrays.asList(skill.split(""));
            Collections.reverse(revSkill);
            stack.addAll(revSkill);

            boolean success = true;
            for(int i=0; i<skillTree.length(); i++) {
                if(stack.contains(skillTree.substring(i, i+1))) {
                    if(stack.peek().equals(skillTree.substring(i, i+1))) {
                        stack.pop();
                    } else {
                        success = false;
                        break;
                    }
                }
            }

            if  (success) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
