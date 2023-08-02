// 백준 한줄로 서기:1138 https://www.acmicpc.net/problem/1138

package bj.bj1138;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {

    int getPoision(int pos, int[] line) {
        int currentPos = 0 ;
        int result = 0;
        for (int i=0; i< line.length; i++) {
            if  (line[i] >  0 ) continue;

            if  (currentPos == pos) {
                result = i;
                break;
            } else
                currentPos += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            int[] cnt = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            int[] answer = new int[N];
            Main main  = new Main();

            for (int i=0 ; i< cnt.length; i++) {
                int result = main.getPoision(cnt[i], answer);
                answer[result] = i+1;
                // System.out.println("getPosition:"+cnt[i]+" "+ result + Arrays.toString(answer));
            }
            String[] answerString = Arrays.stream(answer).mapToObj(String::valueOf).toArray(String[]::new);
            bw.write(String.join(" ",answerString)+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
