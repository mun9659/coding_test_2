package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps(int num) {
        int count = 0;

        while(num > 0) {
            if(num % 2 == 0) num /= 2;
            else num -= 1;

            count++;
        }

        return count;
    }

}
