// 프로그래머스 연습문제 > 귤고르기
// https://school.programmers.co.kr/learn/courses/30/lessons/138476

package pgmers.tangerine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer t : tangerine) {
            int  cnt  = 0;
            if (map.get(t) != null )
                cnt = map.get(t);
            cnt++;
            map.put(t, cnt);
        }

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList,Map.Entry.comparingByValue(Collections.reverseOrder()));

        int sum=0;
        for(Map.Entry<Integer,Integer> e : entryList) {
            sum+=e.getValue();
            answer+=1;
            if (sum>=k) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Tangerine p = new Tangerine();
        int[] ints = new int[] {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(p.solution(6, ints));
        System.out.println(p.solution(4, ints));
        ints = new int[]{1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(p.solution(2, ints));
    }
}

