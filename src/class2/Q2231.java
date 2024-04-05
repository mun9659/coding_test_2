package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = n;

        Deque<Integer> results = new ArrayDeque<>();

        while(count > 0) {
            int sum = count;

            String v = String.valueOf(count);

            for(char value : v.toCharArray())
                sum += Character.getNumericValue(value);

            if(n == sum) results.push(count);

            count--;
        }

        System.out.println(results.isEmpty() ? 0 : results.peek());

    }

}
