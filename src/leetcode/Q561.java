package leetcode;

import java.util.Arrays;

public class Q561 {

    public static void main(String[] args) {
        // 561. Array Partition
        //  - n개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
        // int[] nums = {1, 4, 3, 2};
        int[] nums = {6,2,6,5,1,2};

        // System.out.println(arrayPairSum1(nums));
        System.out.println(arrayPairSum2(nums));
    }

    private static int arrayPairSum1(int[] nums) {
        // 1. 정렬 후 체크
        int result = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i += 2) {
            result += Math.min(nums[i], nums[i + 1]);
        }

        return result;
    }

    private static int arrayPairSum2(int[] nums) {
        // 2. Counting Sort 사용
        int[] counting = new int[20001];

        for(int num : nums)
            counting[num + 10000]++;

        int sum = 0, i = 0;

        for(int n = 0; n < nums.length / 2; n++) {
            while(counting[i] == 0) i++;
            sum += i - 10000;
            counting[i]--;
            while(counting[i] == 0) i++;
            counting[i]--;
        }

        return sum;
    }

}
