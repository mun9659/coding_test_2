package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1480 {

    // 1480. Running Sum of 1d Array

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(runningSum(nums)));

    }

    public static int[] runningSum(int[] nums) {

        int[] sums = new int[nums.length];

        sums[0] = nums[0];

        for(int i = 1; i < sums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }

        return sums;
    }

}
