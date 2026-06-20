package array.algo_company.leetcode;

import java.util.Arrays;

public class ThreeSumCloseMatch {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};

        System.out.println(finClosestMatch(nums, 1));
    }

    private static int finClosestMatch(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++) {

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if(sum > target) {
                    right--;
                }else if(sum < target) {
                    left++;
                }else{
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
