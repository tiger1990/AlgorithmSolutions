package array.algo_company.leetcode;

import java.util.Arrays;

public class RequestCounterGetMaxRequest {

    public static void main(String[] args) {
        long[] timestamps = {1, 10, 5, 6, 15, 7};
        long windowSize = 4;

        System.out.println("Max requests: " + getMaxRequests(timestamps, windowSize));
        // Output: 3 (timestamps 5, 6, 7 fall within a window of 4)
    }

    private static int getMaxRequests(long[] timestamps, long windowSize) {
        if(timestamps == null || timestamps.length == 0){
            return 0;
        }
        // Sort is required for the sliding window to work
        Arrays.sort(timestamps);

        int left = 0;
        int right = 0;
        int maxRequest = 0;

        int bestStart = -1;
        int bestEnd = -1;

        while(right < timestamps.length){

            while (timestamps[right] - timestamps[left] >= windowSize){
                left++;
            }

            int currentWindow = right - left + 1;
            if(currentWindow > maxRequest){
                maxRequest = currentWindow;
                bestStart = left;
                bestEnd = right;
            }
           // maxRequest = Math.max(currentWindow, maxRequest);

            right++;
        }
        System.out.print("[");
        for(int i = bestStart; i <= bestEnd; i++){
            System.out.print(timestamps[i] + " ");
        }
        System.out.print("]\n");

        return maxRequest;
    }
}
