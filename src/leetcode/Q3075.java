package leetcode;

import java.util.Arrays;

public class Q3075 {

    public static void main(String[] args) {
        int[] happiness = {2, 3, 4, 5};
        int k = 3;

        System.out.println(maximumHappinessSum(happiness, k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {

        long result = 0L;

        Arrays.sort(happiness);

        int n = 0, last = happiness.length - 1;
        while(n < k) {
            result += Math.max((happiness[last - n] - n), 0);
            n++;
        }

        return result;
    }

}
