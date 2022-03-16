package array.algo_company.Stack_Ques;

public class StackQueImpl
{
    public static  void main(String... args)
    {
        System.out.println("\n Stack Implementation :: \n");

        Stack stack = new Stack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        int data;
        while((data = stack.pop()) != -1)
        {
            System.out.println(data);
        }


        System.out.println("\n Que Implementation :: \n");

        Que que = new Que();
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);

        int data1;
        while((data1 = que.remove()) != -1)
        {
            System.out.println(data1);
        }

    }
}
