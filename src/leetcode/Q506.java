package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q506 {

    public static void main(String[] args) {

        // int[] score = {5, 4, 3, 2, 1};
        int[] score = {10, 3, 8, 9, 4};

        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    public static String[] findRelativeRanks(int[] score) {

        int len = score.length;

        Map<Integer, Integer> map = new HashMap<>();
        String[] results = new String[len];

        for(int i = 0; i < len; i++)
            map.put(score[i], i);

        Arrays.sort(score);

         for(int i = 0; i < len; i++) {
            if(i == len - 1) {
                results[map.get(score[i])] = "Gold Medal";
            } else if(i == len - 2) {
                results[map.get(score[i])] = "Silver Medal";
            } else if(i == len - 3) {
                results[map.get(score[i])] = "Bronze Medal";
            } else {
                results[map.get(score[i])] = String.valueOf(i + 1);
            }
        }

        return results;
    }

}
