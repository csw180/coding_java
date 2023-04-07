package bj.bj1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
            line = line.trim();
            
            StringTokenizer token = new StringTokenizer(line);
            System.out.println(token.countTokens());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
