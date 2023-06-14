package bj.bj1527;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class BfsHelper {
    List<List<String>> results = new ArrayList<>();

    void addResult(List<Integer> result) {
        results.add(result.stream()
                        .map(t -> t.toString())
                        .collect(Collectors.toList())
        );
    }

    public List<List<String>> getResults() {
        return results;
    }
}

public class Main {
    
    void bfs(int size, BfsHelper helper) {
        Queue<List<Integer>> queue =  new LinkedList<>();
        List<Integer> aCase = new ArrayList<>();
        aCase.add(4);
        queue.add(aCase);
        aCase = new ArrayList<>();
        aCase.add(7);
        queue.add(aCase);
        while (queue.size() > 0) {
            aCase = queue.poll();
            if (aCase.size() < size) {
                List<Integer> newCase = new ArrayList<>(aCase);
                newCase.add(4);
                queue.add(newCase);

                newCase = new ArrayList<>(aCase);
                newCase.add(7);
                queue.add(newCase);
            } else {
                helper.addResult(aCase);
            }
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int length = nums[0].length() > nums[1].length() ? nums[0].length() : nums[1].length();

            Main main   = new Main();
            BfsHelper helper = new BfsHelper();
            for (int i =1 ; i <= length; i++) {
                main.bfs(i,helper);
            }
            final long count =  helper.getResults().stream()
                .mapToLong( e -> Long.parseLong(String.join("",e)))
                .filter( e -> a <= e && e <= b)
                .count();

            bw.write(count+"\n");
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
