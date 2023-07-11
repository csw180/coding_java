// 백준 쿼드트리:1992  https://www.acmicpc.net/problem/1992

package bj.bj1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class QuadZip {
    String[][] arr;

    QuadZip(String[][] arr) {
        this.arr = arr;
    }

    boolean enableOne(int row, int col, int width) {
        if (width==1)  return true;
        String value = arr[row][col];
        for (int i=row; i<row+width; i++) {
            for (int j=col; j<col+width; j++) {
                if (!value.equals(arr[i][j]))
                    return false;
            }
        }
        return true;
    }

    String compress()  {
        String result = compress(0,0,arr.length);
        return result;
    }

    String compress(int r, int c, int width) {
        if (enableOne(r, c,width))
            return arr[r][c];
        
        return "(" +
            compress(r,c,width/2) +
            compress(r,c+width/2,width/2) +
            compress(r+width/2,c,width/2) +
            compress(r+width/2,c+width/2,width/2) + ")";
    }

}

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            String[][] arr = new String[N][N];
            for (int i=0; i<N; i++) {
                String[] sub = br.readLine().split("");
                arr[i] = sub;
            }
            QuadZip quadZip = new QuadZip(arr);
            bw.write(quadZip.compress()+"\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
