// 백준 최대공약수:1850 https://www.acmicpc.net/problem/1850


package bj.bj1850;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    
    long GCD(long a, long b) {
        if(b==0) return a;
        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            long[] ab  = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            Main main = new Main();
            long  count = main.GCD(ab[0], ab[1]);
            for(long i=0; i< count; i++ )
                bw.write("1");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
