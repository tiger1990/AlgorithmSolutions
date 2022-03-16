package array.algo_company.Stack_Ques;

public class Que {

    private Node head , tail;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int peek()
    {
        return head.data;
    }

    public void add(int data)
    {
       Node newNode = new Node(data);

       if(tail != null)
       {
           tail.next = newNode;
       }
       tail = newNode;

        if(head == null)
        {
            head = tail;
        }
    }

    public int remove()
    {
        if(head == null)
        {
            tail = null;
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

}
