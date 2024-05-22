package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q131 {

    public static void main(String[] args) throws IOException {

        // 131. Palindrome Partitioning
        // Given a string s, partition s such that every substring of the partition is a palindrome.
        // Return all possible palindrome partitioning of s.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(parition(s));
    }

    private static List<List<String>> parition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> part = new ArrayList<>();

        backtracking(s, 0, part, result);

        return result;
    }

    private static void backtracking(String s, int index, List<String> part, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(checkPalindrome(s, index, i)) {
                part.add(s.substring(index, i + 1));
                backtracking(s, i + 1, part, result);
                part.remove(part.size() - 1);
            }
        }

    }

    private static boolean checkPalindrome(String s, int start, int last) {
        while(start <= last) {
            if(s.charAt(start) != s.charAt(last))
                return false;

            start++;
            last--;
        }

        return true;
    }

}
