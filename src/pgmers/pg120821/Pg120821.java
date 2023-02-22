package pgmers.pg120821;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Pg120821 {
    public int[] solution(int[] num_list) {
        List<Integer> nList = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        Collections.reverse(nList);
        return nList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Pg120821 s = new Pg120821();
        int[] p = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(s.solution(p)));
        p = new int[] {1, 1, 1, 1, 1, 2};
        System.out.println(Arrays.toString(s.solution(p)));
        p = new int[] {1, 0, 1, 1, 1, 3, 5};
        System.out.println(Arrays.toString(s.solution(p)));
    }
}