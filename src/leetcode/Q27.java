package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q27 {

    public static void main(String[] args) throws IOException {
        // 27. Remove Element
        // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
        // Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
        // Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
        // Return k.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int val = 3;

        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {

        int index = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

}
