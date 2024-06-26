package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Q819 {

    public static void main(String[] args) {

        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String banned = "hit";

        System.out.println(mostCommonWord(paragraph, banned));
    }

    private static String mostCommonWord(String paragraph, String banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] p_arr = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String p : p_arr) {
            if(!banned.contains(p)) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
