package array.algo_company.Stack_Ques;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQues
{
    public static void main(String... args)
    {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        s1.printElements();

        System.out.println("CurrentSize:: "+s1.currentSize);

        System.out.println("Top: "+s1.top());
        System.out.println("Remove:"+s1.pop());

        System.out.println("Top: "+s1.top());
        System.out.println("Remove:"+s1.pop());


        System.out.println("CurrentSize:: "+s1.currentSize);
    }

    static class Stack
    {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int currentSize;

        Stack()
        {
            currentSize  = 0;
        }

        void push(int x)
        {
            currentSize++;

            //push this in empty que q2
            q2.add(x);

            while(!q1.isEmpty())
            {
                q2.add(q1.peek());
                q1.remove();
            }

            Queue temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop()
        {
          if(q1.isEmpty())
          {
              return -1;
          }

          int removedItem = q1.remove();
          currentSize--;

          return removedItem;
        }

        int top()
        {
            if(q1.isEmpty())
            {
                return -1;
            }
            return q1.peek();
        }

        int size()
        {
            return currentSize;
        }

        void printElements()
        {
            Iterator<Integer> iterator = q1.iterator();
            while(iterator.hasNext())
           {
               System.out.println(iterator.next());
           }
        }
    }

}
