package array.algo_company.Threading;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestAbc {

    public static void main(String... args)
    {
        try {
            String sbc = URLEncoder.encode("Pay money to " + "AMAN", "UTF-8")
            .replaceAll("\\+", "%20");
            System.out.println(sbc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

//    public static int getUmbrellas(int n, List<Integer> p) {
//        // Write your code here
//
//        if(n <1 || p == null || p.size() == 0)
//            return -1;
//
//        int index = p.size() -1;
//        Collections.sort(p);
//
//
//        int sumPeople = 0;
//        while(n >= 0 && index >= 0)
//        {
//            sumPeople = sumPeople + (n / p.get(index));
//            n = n % p.get(index);
//            index--;
//        }
//
//        return  n!=0?-1:sumPeople;
//    }


    public static int getUmbrellas(int n, List<Integer> p) {
        // Write your code here

        if(p == null || p.size() == 0 || n <1)
            return -1;

        Collections.sort(p);
        int index = p.size() - 1;

        int bigUmbrella = p.get(index);
        int remaining =  n % bigUmbrella;

        int peopleFit = (int) Math.floor(n/bigUmbrella);

        if(remaining >= 1 && p.size() == 1)
            return -1;
        else
        {
           p.remove(index);
            return  remaining != 0 ?getUmbrellas(remaining,p)+peopleFit: peopleFit;
        }

        //  int count =0;

        //  while(n >= 0 && index >= 0)
        //  {
        //      count = count + (n / p.get(index));
        //      n = n % p.get(index);
        //      index--;
        //  }
        // return n != 0 ? -1: count;
    }


    public static int lastStoneWeight(List<Integer> a) {
        // Write your code here
        if(a == null)return 0;

        PriorityQueue<Integer> stoneQue = new PriorityQueue<>(Collections.reverseOrder());
        for(int index =0; index<a.size(); index++)
        {
            stoneQue.offer(a.get(index));
        }

        while(stoneQue.size() > 1)
        {
            int stone1 = stoneQue.poll();
            int stone2 = stoneQue.poll();
            if(stone1 != stone2)
            {
                int remainingPart = Math.abs(stone1 - stone2);
                stoneQue.offer(remainingPart);
            }
        }
        return stoneQue.size() == 1? stoneQue.poll() : 0;
    }
}
