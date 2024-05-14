package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q20 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        char[] c_arr = s.toCharArray();

        for(char c : c_arr) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;

                char c1 = stack.pop();

                if(c == ')') {
                    if(c1 != '(')
                        return false;
                } else if(c == '}') {
                    if(c1 != '{')
                        return false;
                } else if(c == ']') {
                    if(c1 != '[')
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
