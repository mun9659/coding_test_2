package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q383 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ransomNote = br.readLine();
        String magazine = br.readLine();

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] alphabet = new int[26];

        for(char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, alphabet[c % 26]);
            if(index == -1) {
                return false;
            }

            alphabet[c % 26] = index + 1;
        }
        return true;
    }

}
