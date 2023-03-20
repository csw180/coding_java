package bj.bj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cnt = Integer.parseInt(br.readLine());
            int[] nums = new int[cnt+1];
            int[] case1 = new int[cnt+1];
            int[] case2 = new int[cnt+1];

            for (int i=0; i<cnt; i++) {
                nums[i+1] = Integer.parseInt(br.readLine());
            }

            for (int i=0 ; i<nums.length; i++) {
                if (i==0) continue;
                if (i==1) {
                    case1[i] = nums[i];
                    case2[i] = nums[i];
                    continue;
                }

                case1[i] = case2[i-1] + nums[i];
                case2[i] = Math.max(case1[i-2],case2[i-2]) + nums[i];
            }

            System.out.println(Math.max(case1[cnt],case2[cnt]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
