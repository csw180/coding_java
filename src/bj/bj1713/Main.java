// 백준 후보추천하기:1713 https://www.acmicpc.net/problem/1713

package bj.bj1713;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

class Candidate {
    private int number;
    private int count;

    Candidate(int number) {
        this.number = number;
        this.count = 0;
    }

    public void addCount() {
        this.count ++;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Candidate [number=" + number + ", count=" + count + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Candidate) && ((Candidate) obj).getNumber() == this.number) {
            return true;
        } else
            return false;
    }
}

class Frame {
    private List<Candidate> candidates;
    private int limit;

    Frame(int count) {
        this.candidates = new LinkedList<>();
        this.limit = count;
    }
    
    private int find(Candidate candidate) {
        for (int i=0; i<candidates.size(); i++) {
            if (candidates.get(i).equals(candidate)) {
                return i;
            }
        }
        return -1;
    }

    private void deleteProperCandidate() {
        int minCount = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i=0; i<candidates.size(); i++) {
            if (candidates.get(i).getCount() < minCount) {
                minCount = candidates.get(i).getCount();
                minIdx = i;
            }
        }
        candidates.remove(minIdx);
    }

    public void addCandidate(Candidate candidate) {
        if  (find(candidate) != -1) {
            candidates.get(find(candidate)).addCount();
            // System.out.println(toString());
            return;
        }
        
        if  (candidates.size() >= limit) 
            deleteProperCandidate();
        
        candidates.add(candidate);
        // System.out.println(toString());
    }

    public List<Integer> getCandidateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (Candidate candidate : candidates) {
            numbers.add(candidate.getNumber());
        }
        return numbers;
    }

    public String toString() {
        return "Frame [candidates=" + candidates.toString() + "]";
    }
    
}
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            // int m = Integer.parseInt(br.readLine());
            br.readLine();  // m 은 쓸모없음^^
            Frame frame = new Frame(n);
            Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(e -> frame.addCandidate(new Candidate(e)));
            
            List<Integer> result = frame.getCandidateNumbers();
            Collections.sort(result);
            bw.write(String.join(" ", result.stream()
                .map(String::valueOf)
                .toArray(String[]::new))+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
