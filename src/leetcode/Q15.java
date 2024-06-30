package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q15 {

    public static void main(String[] args) {
        // 15. 3Sum
        //  - 배열 안의 3개 수의 합을 통해 0이 나오는 값을 찾아라.

        int[] nums = {-1, 0, 1, 2, -1, -4};

        // System.out.println(threeSum1(nums));
        System.out.println(threeSum2(nums));
    }

    private static List<List<Integer>> threeSum1(int[] nums) {
        // 1. 브루트 포스 - 시간초과
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        list.sort(Comparator.naturalOrder());

                        if(!result.contains(list))
                            result.add(list);
                    }
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        // 2. 투 포인터
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left, right, sum;

        for(int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            // 간격을 좁혀가며 합 sum 계산
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 합이 0보다 작다면 왼쪽 포인터 이동
                if(sum < 0)
                    left++;
                // 합이 0보다 크다면 오른쪽 포인터 이동
                else if(sum > 0)
                    right--;
                else {
                    // 합이 0인 경우이므로 정답 처리
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 2번 나올 수 있다.
                    while(left < right && nums[left] == nums[left + 1])
                        left++;

                    while(left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }
            }

        }

        return result;
    }
}
