// 백준 신입사원:1946 https://www.acmicpc.net/problem/1946
// 서류심사 5,4,3,2,1 등순으로 소팅을 하고 나면
// 서류심사 5등의 면접시험등수는 서류심사 4,3,2,1등의 면접시험등수의 최소값보다 적어야 한다
// 즉 서류심사에서 이미 다른사람에게 뒤진 상황이라 면접시험은 서류심사에서 앞선사람들을 모두 이겨야한다
// 서류심사 4등의 면접시험등수는 서류심사 3,2,1등의 면접시험등수의 최소값보다 적어야 한다. ... 

package bj.bj9146;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Score implements Comparable<Score> {

    final public int fst;
    final public int snd;

    public Score(String scoreString) {
        String[]  splitedString = scoreString.split(" ");
        this.fst = Integer.parseInt(splitedString[0]);
        this.snd = Integer.parseInt(splitedString[1]);
    }

    @Override
    public String toString() {
        return "Score [fst=" + fst + ", snd=" + snd + "]";
    }

    @Override
    public int compareTo(Score o) {  // 서류심사순으로 소팅할때 필요함
        if (o instanceof Score) {
            return this.fst - o.fst;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                List<Score> scoreList = new ArrayList<>();
                for (int i=0; i < N; i++) {
                    scoreList.add(new Score(br.readLine()));
                }
                Collections.sort(scoreList,Comparator.reverseOrder());  // 서류심사순으로 소팅 5,4,3,2,1등순
                int[] sndArray = scoreList.stream().mapToInt(s -> s.snd).toArray();  // 면접시험등수를 배열로 생성
                int[] minArray = new int[sndArray.length];     // 서류심사가 나보다 나은사람을 대상으로 면접시험등수의 최소값 보관용도
                minArray[minArray.length - 1] = sndArray[sndArray.length - 1];
                for (int i = sndArray.length - 2 ; i > 0; i--) {
                    minArray[i] = Math.min(minArray[i+1], sndArray[i]);
                }
                int passCount = 1;    // 서류심사 1등은 무조건 선발
                for (int i=0; i< sndArray.length-1; i++) {
                    if (sndArray[i] < minArray[i+1]) passCount++;
                }
                bw.write(passCount+"\n");
                bw.flush();
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
