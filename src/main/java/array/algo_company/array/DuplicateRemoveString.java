package array.algo_company.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemoveString {

    public static void main(String... args){

        String abc = "ababcddb";  //output => cb
        String output = getUniqueUsingStack(abc);
        System.out.print("---->"+output);
    }

    public static String getUniqueUsingStack(String input){
        Set<Character> set = new LinkedHashSet<>();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            boolean isNotPresent = set.add(ch);
            if(!isNotPresent){
                set.remove(ch);
            }
        }
        return set.toString();
    }
}
