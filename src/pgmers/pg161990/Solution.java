package pgmers.pg161990;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int[]  result = new int[4];
        List<Integer> xs = new ArrayList<Integer>();
        List<Integer> ys = new ArrayList<Integer>();

        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        int min_x = wallpaper.length;
        int max_x = -1;
        for(int v : xs) {
            if (v < min_x) min_x = v;
            if (v > max_x) max_x = v;
        }

        int min_y = wallpaper[0].length();
        int max_y = -1;
        for(int v : ys) {
            if (v < min_y) min_y = v;
            if (v > max_y) max_y = v;
        }

        result[0] = min_x;
        result[1] = min_y;
        result[2] = max_x+1;
        result[3] = max_y+1;
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] arg = new String[]{".#...", "..#..", "...#."};
        String[] arg = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(s.solution(arg)));
        
    }
}

// javac.exe  pgmers.pg161990.Solution.java
