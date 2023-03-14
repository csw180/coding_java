package etc.permutation;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Permutation {

    int[] arr;
    int n;     // 전체원소갯수
    int m;     // 선택원소갯수
    List<int[]> results;

    Permutation(int[] arr, int m) {
        this.arr = arr;
        results = new ArrayList<int[]>();
        n = arr.length;
        this.m = m;

        int[] tempResult = new int[m];
        boolean[] visit = new boolean[n];
        recursive(tempResult,visit,0);
    }

    private void recursive(int[] result, boolean[] visit,int depth) {
        if  (m == depth) {
            this.results.add(result);
            System.out.println(Arrays.toString(result));
            return;
        }

        int[] tempResult;
        boolean[] tempVisit;
        
        for (int i=0;i<n;i++) {
            if (!visit[i]) {
                tempResult = result.clone();
                tempVisit = visit.clone();
                tempVisit[i] = true;
                tempResult[depth] = arr[i];
                recursive(tempResult, tempVisit,depth+1);
            }
        }
    }

    int[][] getResult() {
        int[][] r = new int[results.size()][m];
        for (int i=0; i< results.size(); i++) {
            r[i] = results.get(i);
        }
        return r;
    }

}
public class Main {

    public static void main(String[] args) {
        int[] param1 = {5,6,7,8};
        Permutation app = new Permutation(param1,3);
        int[][] answer = app.getResult();
        for (int i=0 ; i<answer.length; i++) 
            System.out.println(Arrays.toString(answer[i]));
    }
}
