//프로그래머서 디펜스게임
//https://school.programmers.co.kr/learn/courses/30/lessons/142085?language=java
//PriorityQueue 우선순위큐 이용한 방법
//정확성, 속도 모두만족

package pgmers.nearest;

import java.util.Arrays;

public class Nearest {

	public static void main(String[] args) {
		Solution prob = new Solution();
		System.out.println(Arrays.toString(prob.solution("banana")));
		System.out.println(Arrays.toString(prob.solution("foobar")));
	}

}

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

    	char[] sarry = s.toCharArray();
    	for(int i=0; i<s.length();i++) {
    		int loop = 0;
    		for (loop=1;loop<=i;loop++) {
    			if (sarry[i]==sarry[i-loop]) {
    				answer[i] = loop;
    				break;
    			}
    		}
    		if (answer[i]==0) answer[i]=-1;
    	}
        return answer;
    }
}