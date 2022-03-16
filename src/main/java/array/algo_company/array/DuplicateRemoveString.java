package array.algo_company.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DuplicateRemoveString {

    public static void main(String... args){

        String abc = "abbacddb";  //output => cb

        //By using LinkedList
//        String output = getOutputUsingLinkedList(abc);
//        System.out.print("---->"+output);

        //By using nothing
        String output1 = getOutputUsingNothing("s");
        System.out.print("---->"+output1);
    }

    //This will print only unique and remove a duplicate
    public static String getOutputUsingNothing(String input){

        int length = input.length();
        if(length < 2)//single character
        {
          return input;
        }

        char[] inputArray = input.toCharArray();

        int prev = 0;

        for(int i=1; i<length; i++){

            if(inputArray[prev] != inputArray[i]){
                prev++;
                System.out.println(prev);
                inputArray[prev] = inputArray[i];
            }
        }
        System.out.println(Arrays.copyOfRange(inputArray,0, prev+1));
        return "";
    }

    public static String getOutputUsingLinkedList(String input){

        //LinkedList is an implementation of Deque and List interface
        LinkedList<Character> list = new LinkedList();

        for(int i=0; i<input.length();i++){

            char test = input.charAt(i);

            if(!list.isEmpty()) {
                if(list.getLast() != test) {
                    list.add(input.charAt(i));
                } else{
                    list.removeLast();
                }
            }else{
                list.add(input.charAt(i));
            }
        }

        return list.toString();
    }
}
