package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));

        System.out.println(n / 125 + n / 25 + n / 5);
    }

    public static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");

        for(int i = 2; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        return result;
    }
}
