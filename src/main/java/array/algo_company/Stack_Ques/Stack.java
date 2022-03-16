package array.algo_company.Stack_Ques;

public class Stack {

    private Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if(head == null)
        {
            return -1;
        }

        int data = head.data;
        head = head.next;
        return data;
    }
}
