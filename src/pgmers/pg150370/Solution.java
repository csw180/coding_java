package pgmers.pg150370;

import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> resultList =  new ArrayList<>();
        HashMap<String,Integer> termHash = new HashMap<>();
        for (String term: terms) {
            String[] term_ary = term.split(" ");
            termHash.put(term_ary[0],Integer.valueOf(term_ary[1]));
        }
        int idx=0;
        for (String privacy: privacies) {
            idx++;
            String[] privacy_ary = privacy.split(" ");
            String[] ymd = privacy_ary[0].split("[.]");
            int y = Integer.parseInt(ymd[0]);
            int m = Integer.parseInt(ymd[1]);
            int d = Integer.parseInt(ymd[2]);

            int term = termHash.get(privacy_ary[1]);
            if  (m+term > 12) {
                int mok = (m+term) / 12;
                int r = (m+term) % 12;
                if (r==0) {
                    y += mok -1;
                    m = 12;
                } else {
                    y += mok;
                    m = r;
                }
            }  else 
                m = m+term;

            DecimalFormat df = new DecimalFormat("00");
            String m_text = df.format(m);
            String d_text = df.format(d);

            String exfiredDate = y+"."+m_text+"."+d_text;
            if  (exfiredDate.compareTo(today) <= 0)
                resultList.add(Integer.valueOf(idx));
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
