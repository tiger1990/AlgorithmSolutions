package array.algo_company;

import array.algo_company.DataStructure.Node;

public class LinkedList
{
    private Node head;

    public LinkedList()
    {
        this.head = new Node("Head");
    }

    public Node head() { return head; }

    public void appendToTail(Node data)
    {
        Node current = head;

        while(current.next() != null)
        {
            current = current.next();
        }
        current.setNext(data);
    }

    public boolean isCyclic()
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next() != null)
        {
            slow = slow.next();
            fast = fast.next().next();

            if(slow == fast)
            {
                System.out.println("Cyclic at node ::=> "+slow.data());
                return true;
            }
        }
        return false;
    }

    public static void main(String... args)
    {

        LinkedList linkedList = new LinkedList();
        linkedList.appendToTail(new Node("101"));
        Node cycle = new Node("201");
        linkedList.appendToTail(cycle);
        linkedList.appendToTail(new Node("301"));
        linkedList.appendToTail(new Node("401"));
        linkedList.appendToTail(cycle);

        boolean isCyclic = linkedList.isCyclic();
        System.out.println("Is LinkedList Cyclic :: "+isCyclic);
    }
}
