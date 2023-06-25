// 백준 하노이탑 :1914   https://www.acmicpc.net/problem/1914

package bj.bj1914;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.function.Consumer;

class Hanoi {
    int diskCount;
    Consumer<String> consumer;
    boolean isDebug;

    Hanoi(int diskCount, Consumer<String> consumer) {
        this.diskCount = diskCount;
        this.consumer = consumer;
        if (diskCount <= 20)
            isDebug = true;
        else
            isDebug = false;
    }

    void move(int from, int to) {
        consumer.accept((from+1) + " " + (to+1));
    }

    int getVia(int from, int to) {
        return 3 - from - to;
    }

    void recursive_debug(int n, int from, int to) {
        if(n == 1)
            move(from, to);
        else {
            int via = getVia(from, to);
            recursive_debug(n-1, from, via);
            move(from, to);
            recursive_debug(n-1, via, to);
        }
    } 

    void simulate() {
        if (isDebug)
            recursive_debug(diskCount, 0, 2);
    }
}
public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            Consumer<String> consumer = (x) -> {
                try {
                    bw.write(x+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            };
            bw.write( new BigInteger("2").pow(n).subtract(new BigInteger("1")) + "\n");  
            /* 디스크갯수에 따라 최소이동횟수는 2**n - 1
                1,3,7,15,31, ....
            */
            Hanoi hanoi = new Hanoi(n, consumer);
            hanoi.simulate();
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
