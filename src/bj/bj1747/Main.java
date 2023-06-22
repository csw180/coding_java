// 백준 소수&팰린드롬 https://www.acmicpc.net/problem/1747

package bj.bj1747;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    
    boolean isPalindrome(long n) {
        String originalString  = String.valueOf(n);
        String reverseString   = new StringBuffer(originalString).reverse().toString();
        if (originalString.equals(reverseString)) {
            return true;
        } else {
            return false;
        }
    }

    boolean isPrime(long n) {
        boolean result  = true;
        int sqrtValue = (int)Math.sqrt(n);
        if (n == 1)  return false;
        for (int i = 2; i < sqrtValue+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            Main main  = new Main();
            long i = n;
            while (true) {
                if (main.isPalindrome(i) && main.isPrime(i)) {
                    bw.write(String.valueOf(i)+"\n");
                    bw.flush();
                    break;
                }
                i++;
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
