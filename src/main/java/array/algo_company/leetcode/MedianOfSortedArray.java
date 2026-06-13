package array.algo_company.leetcode;

import java.util.ArrayList;

public class MedianOfSortedArray {
    /**
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */
    public static void main(String[] args) {
        int[] nums1 ={1, 5};
        int[] nums2 = {3, 4};
        double solution = findMedianSortedArrays(nums1, nums2);
        System.out.println(solution);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int start1 = 0;
        int start2 = 0;
        ArrayList<Integer> list1 = new ArrayList<>(nums1.length + nums2.length);

        while(start1 < nums1.length || start2 < nums2.length){

            if(start1 < nums1.length && (start2 == nums2.length || nums1[start1] < nums2[start2])){
                list1.add(nums1[start1++]);
            }else{
                list1.add(nums2[start2++]);
            }
        }
        double output;
        int mid = list1.size()/2;
        if(list1.size() % 2 == 0){
            output = (list1.get(mid-1) + list1.get(mid))/2.0;
        }else{
           output=list1.get(mid);
        }
        return output;
    }
}
