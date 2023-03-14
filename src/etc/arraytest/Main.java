package etc.arraytest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = a.clone();
        b[0] = 9;
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(a));
    }
}
