package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q4949 {

    public static void main(String[] args) throws IOException {

        // 균형잡힌 세상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();

            if(s.equals(".")) break;

            Deque<Character> deque = new ArrayDeque<>();
            boolean check = true;

            for(int i = 0; i < s.length(); i++) {

                if(s.charAt(i) == '(' || s.charAt(i) == '[')
                    deque.push(s.charAt(i));

                if(s.charAt(i) == ')') {
                    if(!deque.isEmpty() && deque.peek() == '(')
                        deque.pop();
                    else {
                        check = false;
                        break;
                    }
                }

                if(s.charAt(i) == ']') {
                    if(!deque.isEmpty() && deque.peek() == '[')
                        deque.pop();
                    else {
                        check = false;
                        break;
                    }
                }
            }

            sb.append(deque.isEmpty() && check ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }

}
