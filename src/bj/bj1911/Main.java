// 백준 흙길보수하기:1911 https://www.acmicpc.net/problem/1911

package bj.bj1911;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Pool implements Comparable<Pool> {
    int from;
    int to;
    Pool(int from,int to){
        this.from  = from;
        this.to = to;
    }

    Pool(String fromtoString) {
        String[] str =fromtoString.split(" ");
        this.from = Integer.parseInt(str[0]);
        this.to = Integer.parseInt(str[1]);
    }

    @Override
    public int compareTo(Pool o) {
        return this.from - o.from;
    }

    @Override
    public String toString() {
        return from+"-"+to;
    }
}

public class Main {
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Pool> poolList = new ArrayList<>();
            for(int i=0;i<nl[0];i++) {
                poolList.add(new Pool(br.readLine()));
            }
            Collections.sort(poolList);
            // System.out.println(poolList);
            int cardboardCount = 0;
            int cardboardTo = 0;
            for (Pool pool : poolList) {
                cardboardTo = Math.max(pool.from,cardboardTo);
                while (cardboardTo < pool.to) {
                    cardboardCount++;
                    cardboardTo += nl[1];
                }
                // System.out.println(pool + " " + cardboardTo + " " + cardboardCount);
            }
            bw.write(cardboardCount+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
