package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q1874 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new LinkedList<>();

        int start = 0;
        while(n-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            } else if(stack.peek() != value) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);

        // 1. 막연히 생각한 코드(3% 틀림)
        // List<Integer> list = new ArrayList<>();
        // Deque<Integer> stack = new LinkedList<>();

        // for(int i = 0; i < n; i++) 
        //     list.add(Integer.parseInt(br.readLine()));
        
        // int count = 1;
        // while(!list.isEmpty()) {

        //     if(count > n) {
        //         sb = new StringBuilder();
        //         sb.append("NO");
        //         break;
        //     }

        //     int num = list.get(0);

        //     if(!stack.isEmpty() && num == stack.peek()) {
        //         sb.append("-").append("\n");
        //         list.remove(0);
        //         stack.pop();
        //     } 
            
        //     else {
        //         sb.append("+").append("\n");
        //         stack.push(count++);
        //     }
        // }
        // System.out.println(sb);
    }
}
