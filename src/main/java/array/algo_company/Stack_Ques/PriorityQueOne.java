package array.algo_company.Stack_Ques;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;

public class PriorityQueOne {

    public static void main(String... args)
    {
        PriorityQueue pq = new PriorityQueue();
        pq.add("C");
        pq.add("C++");
        pq.add("JAVA");
        pq.add("PYTHON");

        Spliterator spliterator = pq.spliterator();
        System.out.println("AFTER SPLIT ITERATOR \n");
        spliterator.forEachRemaining(n -> System.out.println(n));

        Iterator iterator1 = pq.iterator();

        while(iterator1.hasNext())
        {
            String next = (String) iterator1.next();
            System.out.println(""+next);
        }

        pq.poll();

        System.out.println("\n AFTER POLLING \n");

        Iterator iterator2 = pq.iterator();

        while(iterator2.hasNext())
        {
            System.out.println(""+iterator2.next());
        }

        pq.remove("PYTHON");

        System.out.println("\nAFTER REMOVING \n");

        Iterator iterator = pq.iterator();

        while(iterator.hasNext())
        {
            System.out.println(""+iterator.next());
        }

        pq.offer("ABC");
        pq.offer("MBC");

        System.out.println("\nAFTER OFFERING \n");

        Iterator iterator3 = pq.iterator();

        while(iterator3.hasNext())
        {
            System.out.println(""+iterator3.next());
        }

        // Check if an element is present using contains()
        boolean b = pq.contains("C");
        System.out.println ( "\nPriority queue contains C " + "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pq.toArray();
        System.out.println ( "\nValue in array: ");
        for (int i = 0; i<arr.length; i++)
            System.out.println ( "Value: " + arr[i].toString()) ;


    }
}
