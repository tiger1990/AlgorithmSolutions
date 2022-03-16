package array.algo_company.array;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestPaypal {

    enum  ContactInviteAction { ENTER_UPI_ID,TRANSFER_VIA_ACC,INVITE_CONTACT }

    public static void main(String... args){

       System.out.println(ContactInviteAction.ENTER_UPI_ID);
       System.out.println(ContactInviteAction.ENTER_UPI_ID.name());
       System.out.println(ContactInviteAction.ENTER_UPI_ID.ordinal());
       System.out.println(ContactInviteAction.ENTER_UPI_ID.equals(ContactInviteAction.ENTER_UPI_ID));

        ContactInviteAction enumFormed = ContactInviteAction.valueOf(ContactInviteAction.ENTER_UPI_ID.name());
        System.out.println(enumFormed);

//       String input = "abbaca";
//
//       char[] chars = input.toCharArray();
//
//       Stack<Character> stack = new Stack<>();
//
//       for(int i=0; i< chars.length;i++){
//
//           if(!stack.isEmpty()) {
//               if (stack.peek() == chars[i]) {
//                   stack.pop();
//               }
//           }
//           stack.push(chars[i]);
//       }
//
//       while(!stack.isEmpty()){
//           System.out.print(stack.pop());
//       }


//
//        String input = "X.XXXXX.X";
//        solution(input);


        int[] A = {3,0,5};
        solution(A);



    }


//    public int solution(String S) {
//        // write your code in Java SE 8
//        int patchSize=3;
//        AtomicInteger splitCounter = new AtomicInteger(0);
//        Collection<String> splittedStrings = S
//                .chars()
//                .mapToObj(_char -> String.valueOf((char)_char))
//                .collect(Collectors.groupingBy(stringChar ->
//                        splitCounter.getAndIncrement()/patchSize, Collectors.joining()))
//                .values();
//
//        int patchCounter = 0;
//        Iterator<String> iterator = splittedStrings.iterator();
//        while(iterator.hasNext()){
//            String str = iterator.next();
//            if(str.contains("X")){
//                patchCounter++;
//            }
//        }
//        return patchCounter;
//    }


    public static int solution(int[] A) {
        // write your code in Java SE 8
        PriorityQueue<Double> queue =
                new PriorityQueue<>(Comparator.reverseOrder());

        int totalSum = 0;
        for(Integer i : A){
            if(i>0) {
                queue.offer(Double.valueOf(i));
                totalSum += i;
            }
        }

        int minRequiredSum = totalSum/2;
        int sum = 0;
        int filterUsed = 0;

        while(sum < minRequiredSum){

            double maxElement = queue.poll();
            double maxAfterFilter = maxElement/2;
            filterUsed++;
            sum+= maxAfterFilter;

            if(maxAfterFilter > 0){
                queue.offer(maxAfterFilter);
            }
        }

        return filterUsed;
    }


//    public static int solution(String S) {
//        // write your code in Java SE 8
//
//        int patchSize = 3;
//        char potHole = 'X';
//
//        if(S.length() < patchSize)
//        {
//            System.out.print("Patch:"+0);
//            return 0;
//        }
//        char[] roadSegments = S.toCharArray();
//
//        int patchRequired = 0;
//
//
//        for(int i=0;i<patchSize;i++){
//            if(potHole == roadSegments[i]){
//                patchRequired++;
//                break;
//            }
//        }
//
//        if(S.length() == patchSize){
//            return patchRequired;
//        }
//
//        int countSize=0;
//        for(int j=patchSize;j<roadSegments.length;j++)
//        {
//
//            if(potHole == roadSegments[j] && countSize ==0)
//            {
//                patchRequired++;
//                countSize++;
//                continue;
//            }
//        }
//    }
}
