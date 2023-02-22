package pgmers.fruitseller;

import java.util.Arrays;

public class FruitSeller {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        for (int i = score.length%m; i < score.length; i+=m) {
            int subMin =k;
            for (int j = i; j < i+m; j++) if (subMin > score[j]) subMin = score[j];
            answer+=(subMin*m);            
        }
        return answer;
    }

    public static void main(String[] args) {
        FruitSeller p = new FruitSeller();
        int[] ints = new int[]{1, 2, 3, 1, 2, 3, 1};
        System.out.println(p.solution(3,4,ints));
        ints = new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(p.solution(4,3,ints));
    }
}
