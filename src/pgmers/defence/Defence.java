//프로그래머서 디펜스게임
//https://school.programmers.co.kr/learn/courses/30/lessons/142085?language=java
//PriorityQueue 우선순위큐 이용한 방법
//정확성, 속도 모두만족

package pgmers.defence;

import java.util.Collections;
import java.util.PriorityQueue;

public class Defence {

	public static void main(String[] args) {
		Solution prob = new Solution();
		
		int[] problist = new int[] {4, 2, 4, 5, 3, 3, 1};
		System.out.println(prob.solution(7, 3,problist));

		problist = new int[] {3, 3, 3, 3};
		System.out.println(prob.solution(2, 4,problist));
	}

}

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = -1;
        int kcnt = 0;
        int pqsum = 0;
        int loopcnt =0;
        		
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int v : enemy) {
        	loopcnt++;
        	pq.add(new Integer(v));
        	pqsum+=v;
        	if (pqsum > n) {
        		if (kcnt >= k) {
        			answer = loopcnt-1;
        			break;
        		} else {
        			int tmp = pq.poll();
        			pqsum-=tmp;
        			kcnt++;
        		}
        	}	
        }
        if (answer==-1)
        	answer = enemy.length;
        
        return answer;
    }
}