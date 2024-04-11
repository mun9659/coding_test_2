package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();

            Deque<Character> stack = new ArrayDeque<>();
            boolean check = true;

            for(char ch : chars) {
                if(ch == ')') {
                    if(stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    else
                        stack.pop();
                }

                if(ch == '(')
                    stack.push(ch);
            }

            if(stack.isEmpty() && check) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
