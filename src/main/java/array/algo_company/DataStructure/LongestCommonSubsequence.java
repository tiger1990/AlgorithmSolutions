package array.algo_company.DataStructure;

import java.util.HashMap;

public class LongestCommonSubsequence {

    public static void main(String... args) {

//        String str1 = "AGGTAB";
//        String str2 = "GXTXAYB";

        //worst case O(2^n) when all character of both array mismatch `ie length of LCS =0
        //Overlapping Substructure property

        //                        lcs("AXYT", "AYZX")
        //                       /
        //         lcs("AXY", "AYZX")                      lcs("AXYT", "AYZ")
        //         /                                       /
        //lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")


        String str1 = "ABCDGH";
        String str2 = "AEDFHR";

        int m = str1.length();

        int n = str2.length();

        HashMap<String,String> store = new HashMap<>();

        String lcs = lcs(str1.toCharArray(),str2.toCharArray(),m-1,n-1,store);
        System.out.println("LCS = "+lcs +" length = "+lcs.length());

    }

    private static String lcs(char[] x, char[] y, int m, int n, HashMap<String, String> store)
    {
        if (m < 0 || n < 0) {
            return "";
        }

        if(x[m] == y[n])
        {
            String lowest =  lcs(x,y, m-1, n-1, store) + x[m];

            store.put(m+","+n,lowest);

            return lowest;
        }
        else
        {
            int start1 = m-1, end1 = n;

            String firstPart;
            if(store.containsKey(start1+","+end1)) {
                 firstPart = store.get(start1+","+end1);
            }else
            {
                firstPart = lcs(x, y, start1, end1, store);
            }

            int start2 = m, end2 = n-1;
            String secondPart;
            if(store.containsKey(start2+","+end2)) {

                secondPart = store.get(start2+","+end2);
            }else {
                secondPart = lcs(x, y, start2, end2, store);
            }

            return firstPart.length() > secondPart.length()? firstPart : secondPart;
        }
    }


//    private static String lcs(char[] x, char[] y, int m, int n)
//    {
//        if (m < 0 || n < 0) {
//            return "";
//        }
//
//        if(x[m] == y[n])
//        {
//            return lcs(x,y, m-1, n-1) + x[m];
//        }
//        else
//        {
//            String firstPart = lcs(x,y,m-1,n);
//
//            String secondPart = lcs(x,y,m,n-1);
//
//            return firstPart.length() > secondPart.length()? firstPart : secondPart;
//        }
//    }
}
