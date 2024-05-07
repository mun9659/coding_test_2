package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {

        String s1 = String.valueOf(x);
        String s2 = new StringBuilder(s1).reverse().toString();

        System.out.println(s1 + " | " + s2);

        return s1.equals(s2);
    }

}
