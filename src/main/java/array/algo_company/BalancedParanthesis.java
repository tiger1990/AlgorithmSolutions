package array.algo_company;

import java.util.Stack;

public class BalancedParanthesis
{
    public static char[] paranthArray = {'{','c','}','(','c',')','['};

    static class Stack
    {
       int top = -1;
       int stackLength = paranthArray.length + 1;
       int stackLimit = paranthArray.length;

       char[] stack = new char[stackLength];

       public void push(char character)
       {
          if(top == stackLimit)
          {
              System.out.println("Stack is full");
          }
          else
          {
              stack[++top] = character;
          }
       }

       public char pop()
       {
           if(top == -1)
           {
               System.out.println("Stack is empty");
               return '\0';
           }
           else
           {
               char element = stack[top];
               top--;
               return element;
           }
       }

       public boolean isEmpty()
       {
           return top == -1;
       }
    }

    public static void main(String... args)
    {
        boolean isBalanced = areParenthesisBalanced();
        System.out.println("Parenthesis are "+(isBalanced?"Balanced":"Not Balanced"));
    }

    private static boolean areParenthesisBalanced()
    {
        Stack stack = new Stack();

        for(int i=0; i<paranthArray.length; i++)
        {
            char element = paranthArray[i];
            if(isStartingParenthesis(element))
            {
                stack.push(element);
            }

            if(isEndingParenthesis(element))
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                if(!isMatchingParenthesisPair(stack.pop(),element))
                {
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    private static boolean isStartingParenthesis(char character)
    {
        return ((character == '{') || (character == '[') || (character == '('));
    }

    private static boolean isEndingParenthesis(char character)
    {
        return ((character == '}') || (character == ']') || (character == ')'));
    }

    private static boolean isMatchingParenthesisPair(char char1, char char2)
    {
        if(char1 == '{' && char2 == '}')
        {
           return true;
        }
        else if(char1 == '(' && char2 == ')')
        {
           return true;
        }
        else if(char1 == '[' && char2 == ']')
        {
           return true;
        }
        else return false;
    }
}
