package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = Arrays.stream(st.nextToken().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(st.nextToken());

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {

        // 1. 브루트 포스
        // int[] result = new int[2];
        //
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target)
        //             result = new int[]{i, j};
        //     }
        // }

        // 2. 2-pass 해쉬 맵
        // Map<Integer, Integer> numMap = new HashMap<>();
        //
        // for(int i = 0; i < nums.length; i++) {
        //     numMap.put(nums[i], i);
        // }
        //
        // for(int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if(numMap.containsKey(complement) && numMap.get(complement) != i) {
        //         return new int[] { i, numMap.get(complement) };
        //     }
        // }

        // 3. 1-pass 해쉬 맵
        // Map<Integer, Integer> numMap = new HashMap<>();
        //
        // for(int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if(numMap.containsKey(complement) && numMap.get(complement) != i) {
        //         return new int[] { i, numMap.get(complement) };
        //     }
        //
        //     numMap.put(nums[i], i);
        // }

        // 4. 브루트 포스 변형, 뒤에서도 체크(무조건 1개의 답안이 있다는 가정이 있기에 가능)
        int size = nums.length;
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }

                if(nums[size - 1 - i] + nums[j] == target) {
                    return new int[] { size - 1 - i, j };
                }
            }
        }
        
        return new int[]{};
    }

}
