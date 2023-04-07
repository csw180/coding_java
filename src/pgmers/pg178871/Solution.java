package pgmers.pg178871;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> d2key = new HashMap<>();
        
        for(int i=0; i< players.length;i++) {
            d2key.put(players[i],i);
        }
        
        for (String call : callings) {
            int k = d2key.get(call);
            d2key.put(players[k-1], k);
            d2key.put(call,k-1);
            String temp  = new String();
            temp  = players[k-1];
            players[k-1] = players[k];
            players[k] = temp;
        }
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(players, callings)));
    }
}
