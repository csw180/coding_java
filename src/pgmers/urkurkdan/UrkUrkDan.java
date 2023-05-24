// 프로그래머스 연습문제 > 억억단을 외우자
// https://school.programmers.co.kr/learn/courses/30/lessons/138475
// 데스트10 만 시간초과

package pgmers.urkurkdan;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UrkUrkDan {

    public int factorCount(int n) {
        int count=0;
        int max = (int)Math.sqrt(n);
        for (int i=2; i<=max; i++) if (n%i==0) count+=2;
        if  (max*max==n) count++;
        else count+=2;
        return count;
    }

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] maxcount = new int[e];

        int maxvalue = 0;
        int maxvalueIdx=e;
        int startsMin = IntStream.of(starts).min().getAsInt();
        for(int i=e; i>=startsMin; i--) {
            int factorCnt = factorCount(i);
            if  (factorCnt >= maxvalue) {
                maxvalue = factorCnt;
                maxvalueIdx = i;
            }
            maxcount[i-1]=maxvalueIdx;
            // System.out.println(Arrays.toString(maxcount));
        }
        for(int i=0; i<starts.length; i++) {
            answer[i] = maxcount[starts[i]-1];
        }
        // answer = IntStream.of(starts).map(a->maxcount[a-1]).toArray();

        return answer;
    }

    public static void main(String[] args) {
        UrkUrkDan p =  new UrkUrkDan();
        int[] ints = new int[]{1,3,7};
        System.out.println(Arrays.toString(p.solution(8,ints)));
    }
}
