package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q412 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // System.out.println(fizzbuzz(n));
        System.out.println(fizzbuzz2(n));
    }

    public static List<String> fizzbuzz(int n) {

        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public static List<String> fizzbuzz2(int n) {

        return new java.util.AbstractList<>() {
            @Override
            public String get(int i) {
                i++;
                if(i % 15 == 0) return "FizzBuzz";
                else if(i % 3 == 0) return "Fizz";
                else if(i % 5 == 0) return "Buzz";
                else return String.valueOf(i);
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}
