package bj.bj1100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    if  ((line.charAt(j) == 'F') && (i%2 == j%2))
                        count++;
                }
            }
            bw.write(count+"\n");
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
