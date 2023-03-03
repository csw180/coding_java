package pgmers.weaponmake;

public class WeaponMake {

    public int factorCount(int n) {
        int count=0;
        int max = (int)Math.sqrt(n);
        for (int i=2; i<=max; i++) if (n%i==0) count+=2;
        if  (max*max==n) count++;
        else count+=2;
        return count;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int factorCnt = factorCount(i);
            if (factorCnt > limit)
                answer+=power;
            else
                answer+=factorCnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        WeaponMake p  = new WeaponMake();
        System.out.println(p.solution(5, 3, 2));
        System.out.println(p.solution(10, 3, 2));
    }
}
