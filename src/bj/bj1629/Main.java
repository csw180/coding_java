// 백준 곱셈:1629  https://www.acmicpc.net/problem/1629

package bj.bj1629;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    long divideConquer(int a, int b , int c) {
        // divide and conquer 분할정보
        // 2^10  = 2^5 * 2^5
        // 2^10 mod c = (2^5 mod c * 2^5 mod c) mod c
        if (b==1)
            return a % c;

        long s = divideConquer(a, b/2, c);
        if (b%2==0)
            return (s * s) % c;
        else 
            return ( (s * s) % c * ( a % c) ) % c;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            
            Main main = new Main();
            long result = main.divideConquer(nums[0], nums[1], nums[2]);
            bw.write(result+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
