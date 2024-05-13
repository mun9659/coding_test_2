package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14 {

    public static void main(String[] args) throws IOException {

        // 14. Longest Common Prefix
        // Write a function to find the longest common prefix string amongst an array of strings.
        // If there is no common prefix, return an empty string "".

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(",");

        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()) {
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }

        return s1.substring(0, idx);
    }

}
