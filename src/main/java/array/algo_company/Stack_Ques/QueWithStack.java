package array.algo_company.Stack_Ques;

import java.util.Stack;

public class QueWithStack {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public static void main(String... args)
    {
        QueWithStack queWithStack = new QueWithStack();
        queWithStack.enqueue(1);
        queWithStack.enqueue(2);
        queWithStack.enqueue(3);
        queWithStack.enqueue(4);

        while(!queWithStack.isEmpty())
        {
            System.out.println("\n"+queWithStack.dequeue());
        }
    }

    private void enqueue(Integer number)
    {
        // Move all elements from s1 to s2
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        // Push item into s1
        stack1.push(number);

        // Push everything back to s1
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }

    private boolean isEmpty()
    {
        return stack1.isEmpty();
    }

    private Integer dequeue()
    {
       if(stack1.isEmpty())
       {
           return -1;
       }
       return stack1.pop();
    }
}
