// 프로그래머스 연습문제 > 억억단을 외우자
// https://school.programmers.co.kr/learn/courses/30/lessons/138475

package pgmers.urkurkdan;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UrkUrkDan2 {

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];

        int[] mat = new int[e+1];
        for (int i = 1; i <= e; i++)
            for (int j = 1; j <= e / i; j++)
                mat[i * j]++;
        // System.out.println(Arrays.toString(mat));
        int maxvalue = 0;
        int maxvalueIdx =0;
        int[] maxmat = new int[mat.length];

        for(int i=mat.length-1;i>=0; i--) {
            if  (mat[i] >= maxvalue) {
                maxvalue = mat[i];
                maxvalueIdx = i;
            }
            maxmat[i]=maxvalueIdx;
        }
        // System.out.println(Arrays.toString(maxmat));
        answer = IntStream.of(starts).map(a->maxmat[a]).toArray();
        return answer;
    }

    public static void main(String[] args) {
        UrkUrkDan2 p =  new UrkUrkDan2();
        int[] ints = new int[]{1,3,7};
        System.out.println(Arrays.toString(p.solution(8,ints)));
    }
}
