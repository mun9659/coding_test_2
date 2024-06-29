package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q42 {

    public static void main(String[] args) {
        // 42. Trapping Rain Water
        // int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println(trap2(height));
    }

    private static int trap1(int[] height) {
        // 1. 투 포인터

        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        while(left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
    
    private static int trap2(int[] height) {
        // 2. 스택 쌓기
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < height.length; i++) {
            // 변곡점 - 숫자 작은 값에서 큰 값으로 '변하는' 위치점.
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                
                if(stack.isEmpty())
                    break;

                // 스택의 마지막 위치까지의 거리로 계산
                int distance = i - stack.peek() - 1;

                // 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()])  - height[pop];

                // 물이 쌓이는 양은 거리와 물 높이의 곱
                result += distance * waters;
            }
            stack.push(i);
        }
        return result;
    }

}
