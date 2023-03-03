// 프로그래머스 연습문제 > 점찍기
// https://school.programmers.co.kr/learn/courses/30/lessons/140107

package pgmers.dotprint;

public class DotPrint {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i=0;i<=(d/k)*k;i+=k){
            int cirX =(int)Math.sqrt(Math.pow(d,2)-Math.pow(i,2));  // 원의방정식
            cirX=(cirX/k)*k; //어떤수N을 K로 나눈정수에 K를 다시곱하면
                             // N보다 작은 K의배수중 최대값이 나온다.
            answer = answer + ((cirX/k)+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        DotPrint p =  new DotPrint();
        System.out.println(p.solution(2,4));
        System.out.println(p.solution(1,5));

    }
}
