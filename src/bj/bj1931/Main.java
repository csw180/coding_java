// 백준 회의실 배정(1931) https://www.acmicpc.net/problem/1931

package bj.bj1931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(String[] startEnd) {
        this.start = Integer.parseInt(startEnd[0]);
        this.end = Integer.parseInt(startEnd[1]);
    }

    @Override
    public String toString() {
        return start + " " + end + "\n" ;
    }

    @Override
    public int compareTo(Meeting o) {
        if (o instanceof Meeting) {
            if  (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        } else {
            throw new ClassCastException("Not a Meeting");
        }
    }
}
public class Main {
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            List<Meeting> list = new ArrayList<>();
            for (int i=0; i< N; i++) {
                list.add(new Meeting(br.readLine().split(" ")));
            }
            Collections.sort(list);
            // System.out.println(list);
            int leadIdx = 0;
            int count = 1;  // 첫번째 회의는 무조건 대상
            for (int i=1; i<list.size(); i++)
                if (list.get(i).start >= list.get(leadIdx).end) {
                    leadIdx = i;
                    // System.out.println(list.get(leadIdx).toString() + list.get(i).toString());
                    count++;
                }
            bw.write(count + "");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
