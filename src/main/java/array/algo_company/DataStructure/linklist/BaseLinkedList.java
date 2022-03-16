package array.algo_company.DataStructure.linklist;

import array.algo_company.DataStructure.Node;

public class BaseLinkedList implements ILinkedCollection
{
    Node head;
    int size;

    public static void main(String... args)
    {
        BaseLinkedList linkedList = new BaseLinkedList();
        linkedList.addToFront("A");
        linkedList.addToFront("B");
        linkedList.addToFront("C");

        linkedList.addToBack("D");
        linkedList.addToBack("E");
        linkedList.addToBack("F");

        linkedList.addToBack("1");
        linkedList.addToBack("2");
        linkedList.addToBack("3");
        linkedList.addToBack("4");
        linkedList.delete("2");

        printLinkedList(linkedList.head);
    }

    public static void printLinkedList(Node node)
    {
        if(node == null) return;

        Node currentNode = node;
        System.out.println(currentNode.data());
        if(currentNode.next != null)
        {
            printLinkedList(currentNode.next);
        }
    }

    @Override
    public void addToFront(String data)
    {
        Node newNode =  new Node(data);
        if(head == null)
        {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addToBack(String data)
    {
       Node newNode = new Node(data);
       if(head == null)
       {
          head = newNode;
           size++;
          return;
       }
       Node currentNode = head;
       while(currentNode.next != null)
       {
           currentNode = currentNode.next;
       }
        currentNode.next = newNode;
        size++;
    }

    @Override
    public String getFirst() throws Exception
    {
        if(head == null)
        {
            throw new Exception("Link List Is Empty");
        }
        return head.data();
    }

    @Override
    public String getLast() throws Exception
    {
        if(head == null)
        {
            throw new Exception("Link List Is Empty");
        }
        Node currentNode = head;
        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }
        return currentNode.data();
    }

    @Override
    public int size()
    {
//        if(head == null)
//        {
//            return 0;
//        }
//
//        int count =1;
//        Node currentNode = head;
//        while(currentNode.next != null)
//        {
//            currentNode = currentNode.next;
//            count++;
//        }
//        return count;

        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void delete(String data)
    {
        if(head == null || data == null)return;

        if(head.data().equals(data))
        {
            head = head.next;
            size--;
            return;
        }

        Node currentNode = head;
        while(currentNode.next != null)
        {
            if(currentNode.next.data().equals(data))
            {
                currentNode.next = currentNode.next.next;
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }
}
