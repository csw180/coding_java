package bj.bj27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        int n=0;
        try {
            s = br.readLine();
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s.charAt(n-1));
    }
}
