package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0, check = 665;

        while(n != count) {
            check++;

            if(String.valueOf(check).contains("666"))
                count++;
        }

        System.out.println(check);
    }

}
