package bj.bj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            HashSet<String> hs  = new HashSet<>();
            for (int i=0; i<n; i++) {
                hs.add(br.readLine());
            }

            List<String> words = new ArrayList<>(hs);

            Collections.sort(words,new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() < o2.length())
                        return -1;
                    else if  (o1.length() > o2.length())
                        return 1;
                    else 
                        return o1.compareTo(o2);
                }
            });
            for (String s : words) {
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
