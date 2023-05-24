// 프로그래머스 연습문제 > 명예의전당
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

package pgmers.halloffame;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {

    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        int answerIdx = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int score:scores) {
            q.add(score);
            if (q.size() > k) 
                q.poll();
            answer[answerIdx] = q.peek();
            answerIdx++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        HallOfFame p = new HallOfFame();
        int[] ints = new int[] {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(p.solution(3,ints)));
        ints = new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(Arrays.toString(p.solution(4,ints)));

    }
}
