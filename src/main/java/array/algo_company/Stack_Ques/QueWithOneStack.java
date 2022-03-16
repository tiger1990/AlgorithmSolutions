package array.algo_company.Stack_Ques;

import java.util.Stack;

public class QueWithOneStack {

    private static Stack<Integer> stack1 = new Stack();

    public static void main(String... args)
    {
        QueWithOneStack queWithOneStack = new QueWithOneStack();
        queWithOneStack.enqueue(1);
        queWithOneStack.enqueue(2);
        queWithOneStack.enqueue(3);
        queWithOneStack.enqueue(4);
        queWithOneStack.enqueue(5);

        while(!queWithOneStack.isEmpty())
        {
            System.out.println(""+queWithOneStack.dequeue(stack1));
        }
    }

    private void enqueue(int number) {
        stack1.push(number);
    }

    private boolean isEmpty() {
        return stack1.isEmpty();
    }

    private Integer dequeue(Stack<Integer> stack) {

      int x,firstItemInStack;

      if(stack.isEmpty()) {
          return -1;
      }

      if(stack.size() ==1)
      {
          return stack.pop();
      }
      else
      {
          x = stack.pop();

          firstItemInStack = dequeue(stack);

          stack.push(x);

          return firstItemInStack;
      }
    }
}
