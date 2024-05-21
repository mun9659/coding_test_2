package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78 {

    public static void main(String[] args) throws IOException {

        // 78. Subsets
        // Given an integer array nums of unique elements, return all possible subsets (the power set).
        //
        // The solution set must not contain duplicate subsets. Return the solution in any order.
        // BackTracking, DFS

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

}
