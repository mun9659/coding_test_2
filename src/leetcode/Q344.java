package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q344 {

    public static void main(String[] args) throws IOException {

        // Q344. Reverse String
        // Write a function that reverses a string. The input string is given as an array of characters s.
        //
        // You must do this by modifying the input array in-place with O(1) extra memory.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        // char[] s_arr = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};

        reverseString(s);

        System.out.println(s);
    }

    private static void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++) {
            char temp;

            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
