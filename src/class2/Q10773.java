package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            int num = Integer.parseInt(br.readLine());

            if(num == 0)
                stack.pop();
            else
                stack.push(num);
        }
        System.out.println(stack.stream().reduce(0, Integer::sum));
    }
}
