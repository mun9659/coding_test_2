package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1863 {

    public static void main(String[] args) throws IOException {
        // 1863. Sum of All Subset XOR Totals
        // The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
        //
        // For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
        // Given an array nums, return the sum of all XOR totals for every subset of nums.
        //
        // Note: Subsets with the same elements should be counted multiple times.
        //
        // An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(subsetXORSum(nums));
    }

    private static int subsetXORSum(int[] nums) {

        // int n = nums.length, sum = 0;
        //
        // for(int i = 0; i < (1 << n); i++) {
        //     int subsetXor = 0;
        //     for(int j = 0; j < n; j++) {
        //         if((i & (1 << j)) != 0)
        //             subsetXor ^= nums[j];
        //     }
        //
        //     sum += subsetXor;
        // }

        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int index, int currentXor) {
        if(index == nums.length) {
            return currentXor;
        }

        int include = dfs(nums, index + 1, currentXor ^ nums[index]);
        int exclude = dfs(nums, index + 1, currentXor);

        return include + exclude;
    }

}
