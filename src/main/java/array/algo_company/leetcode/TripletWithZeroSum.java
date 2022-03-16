package array.algo_company.leetcode;

import java.util.*;

public class TripletWithZeroSum {

    public static void main(String... args){
//        int[] array = {0, -1, 2, -3, 1,9,10,11,-12};
//        int n =array.length;
//        System.out.println("triplet found  :"+findTriplets(array,n));
//
//        System.out.println("triplet found  :"+findTripletsWithSet(array,n));
//
//        int[] array ={-1,0,1,2,-1,-4};
//        int n =array.length;
//        System.out.println("triplet found  :"+findTripletsWithReducedSpace(array,n));

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for(List<Integer> listTriplet : lists){
            System.out.println("triplet found  :"+listTriplet.get(0)+" "+listTriplet.get(1)+" "+listTriplet.get(2));
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i<length-1; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = length -1;
            int initialNum = nums[i];

            while(left < right){

                if(right < length-1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }

                int sum = initialNum + nums[left]+ nums[right];

                if(sum == 0){

                    triplets.add(Arrays.asList(initialNum,nums[left],nums[right]));
                    left++;
                    right--;
                }else if(sum < 0){

                    left++;
                }else{
                    right--;
                }
            }
        }
        return triplets;
    }

    private static boolean findTriplets(int[] array, int n) {
       boolean found = false;
       for(int i=0; i<n-2;i++){

           for(int j=i+1;j<n-1;j++){

               for(int k= j+1; k<n ; k++){

                   if(array[i]+array[j]+array[k] == 0){
                       System.out.println("triplet found  :"+array[i]+" "+array[j]+" "+array[k]);
                       found = true;
                   }
               }
           }
       }
        return found;
    }

    //Time complexity = O(n2); Space Complexity: O(n).
    private static boolean findTripletsWithSet(int[] array, int n) {
        boolean found = false;
        for(int i=0; i<n-1;i++){

            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++){

                int num = -(array[i]+ array[j]);
               if(set.contains(num)){
                   System.out.println("triplet found  :"+array[i]+" "+array[j]+" "+num);
                   found = true;
               }else{
                   set.add(array[j]);
               }
            }
        }
        return found;
    }

    //reduce it to space O(1) and Time: O(n2)
    private static boolean findTripletsWithReducedSpace(int[] array, int n) {
        boolean found = false;

        Arrays.sort(array);
        for(int i=0; i< n-2; i++){

            //for every index i create left and right
            int left = i+1;
            int right = n-1;
            int numInitial = array[i];

            while(left < right){

                int sum = numInitial + array[left]+ array[right];
                if(sum == 0){

                    System.out.println("triplet found  :"+numInitial+" "+array[left]+" "+array[right]);
                    found = true;
                    left++;
                    right--;

                }else if(sum < 0){
                      //since array is sorted so increment left value and increase num from left
                    left++;
                }else{
                    //since array is sorted so decrement right to reduce sum
                    // (right most element is greatest as array is sorted)
                    right--;
                }
            }
        }
        return found;
    }
}
