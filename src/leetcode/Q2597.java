package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2597 {

    public static void main(String[] args) throws IOException {

        // 2597. The Number of Beautiful Subsets

        // You are given an array nums of positive integers and a positive integer k.
        //
        // A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.
        //
        // Return the number of non-empty beautiful subsets of the array nums.
        //
        // A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());

        System.out.println(beautifulSubsets(nums, k));

    }

    static int count = 0;

    private static int beautifulSubsets(int[] nums, int k) {

        count = 0;

        subSetArr(nums, 0, new ArrayList<>(), k);

        return count - 1;
    }

    private static void subSetArr(int[] nums, int i, List<Integer> part, int k) {
        if (i >= nums.length) {
            count++;
            return;
        }
        if (isSafe(nums, part, i, k)) {
            part.add(nums[i]);
            subSetArr(nums, i + 1, part, k);
            part.remove(part.size() - 1);
        }
        subSetArr(nums, i + 1, part, k);
    }

    private static boolean isSafe(int nums[], List<Integer> part, int j, int k) {
        for (int i = 0; i < part.size(); i++) {
            if (Math.abs(nums[j] - part.get(i)) == k) {
                return false;
            }
        }

        return true;
    }

}
