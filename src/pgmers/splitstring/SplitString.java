// 프로그래머서 연습문제 > 문자열 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/140108

package pgmers.splitstring;
// import java.util.Arrays;

public class SplitString {
    public int solution(String str) {
        char[] sarray = str.toCharArray();
        char delim = sarray[0];
        int same = 0 ;
        int diff = 0 ;
        int matched = 0;
        // System.out.println(Arrays.toString(sarray));
        for (int i=0; i<sarray.length; i++) {
            if (delim==sarray[i]) 
                same++;
            else 
                diff++;
            if (same==diff)  {
                matched++;
                if  (i+1==sarray.length)
                    return matched;
                delim =  sarray[i+1];
                same = 0;
                diff = 0;
            }
        }
        return matched+1;
    }

    public static void main(String[] args) {
        
        SplitString s = new SplitString();
        System.out.println(s.solution("banana"));
        System.out.println(s.solution("abracadabra"));
        System.out.println(s.solution("aaabbaccccabba"));

    }
}