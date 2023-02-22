package pgmers.pg120808;

class Solution {

    int GCD(int a, int b) {
        int tmp;
        while(b!=0){      //b가 0이 될 때까지
          tmp = a % b;
          a = b;
          b = tmp;
        }
        return a;   
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[] {0,0};
        int number = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;
        System.out.println(number+","+denom);
        int ret = GCD(number,denom);
        answer[0] = number/ret;
        answer[1] = denom/ret;     
        return answer;
    }
}