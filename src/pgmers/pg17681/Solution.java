package pgmers.pg17681;

import java.util.Arrays;

public class Solution {

    String binString(int size, int bin) {
        StringBuilder str = new StringBuilder();
        int rem = 0;
        int div = bin;
        for ( int i=0; i<size ; i++) {
            rem  = div % 2;
            div  /=  2;
            if  (rem == 0) {
                str.insert(0," ");
            } else  {
                str.insert(0,"#");
            }
        }
        return str.toString();
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0 ; i< n; i++) {
            answer[i] = binString(n,arr1[i] | arr2[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int n = 5;
        // int[] arr1 = new int[] {9, 20, 28, 18, 11};
        // int[] arr2 = new int[] {30, 1, 21, 17, 28};
        int n = 6;
        int[] arr1 = new int[] {46, 33, 33 ,22, 31, 50};
        int[] arr2 = new int[] {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));
    }
}
