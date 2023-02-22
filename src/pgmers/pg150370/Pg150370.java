package pgmers.pg150370;

import java.util.Arrays;

public class Pg150370 {
    public static void main(String[] args) {

        Solution s = new Solution();
        String today="2022.05.19";
        String[] terms = new String[] {"A 6", "B 12", "C 3"};
        String[] privacy = new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(s.solution(today,terms,privacy)));

        today="2020.01.01";
        terms = new String[] {"Z 3", "D 5"};
        privacy = new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(s.solution(today,terms,privacy)));

    }
    
}


//  /usr/lib/jvm/java-11-openjdk-amd64/bin/javac -cp /mnt/c/ITwork/java/pgmers/bin -d /mnt/c/ITwork/java/pgmers/bin  /mnt/c/ITwork/java/pgmers/src/pgmers/pg150370/*.java