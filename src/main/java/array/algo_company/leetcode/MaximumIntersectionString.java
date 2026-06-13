package array.algo_company.leetcode;


public class MaximumIntersectionString {

    public static void main(String[] args) {
        String str = "aabadacaaaaadabaabb"; int k=1;
       String outPut = findMaxIntersectionString(str, k);
       System.out.println(outPut);
    }

    private static String findMaxIntersectionString(String str, int k) {

        int len = str.length();
        int left = 0;
        int right = 1;
        int maxWindowLength = Integer.MIN_VALUE;
        int start = 0;
        boolean matchFound;
        String output = "";

        while (right < len) {

            int prevAscii = str.charAt(left);
            int nextAscii = str.charAt(right);
            int diff = Math.abs(prevAscii - nextAscii);

            if(diff <= k){
               matchFound = true;
            }else{
                matchFound = false;
                start = right;
            }

            right++;
            left++;

            if(matchFound){
                int curWindowLength = right - start;
                if(curWindowLength > maxWindowLength){
                    maxWindowLength = curWindowLength;
                    output = str.substring(start, start + curWindowLength);
                }
            }
        }
        return output;
    }
}
