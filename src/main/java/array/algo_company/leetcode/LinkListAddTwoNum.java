package array.algo_company.leetcode;

import java.util.Stack;

public class LinkListAddTwoNum {

    public static void main(String... args) {
        NodeTest.ListNode l1 = new NodeTest.ListNode(9,
                new NodeTest.ListNode(9,
                        new NodeTest.ListNode(9,
                                new NodeTest.ListNode(9,
                                        new NodeTest.ListNode(9,
                                                new NodeTest.ListNode(9,
                                                        new NodeTest.ListNode(9, null)))))));

        NodeTest.ListNode l2 = new NodeTest.ListNode(9,
                new NodeTest.ListNode(9, new NodeTest.ListNode(9,
                        new NodeTest.ListNode(9, new NodeTest.ListNode(9, null)))));

        NodeTest.ListNode l3 = new NodeTest().addTwoNumbers(l1, l2);

        System.out.println("  SUM ");
        while (l3.next != null) {
            System.out.print(l3.data);
            l3 = l3.next;
        }
        System.out.println(l3.data);

        testAddTwoLinkedList();
    }

    static class NodeTest {
        public static class ListNode {
            int data;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.data = val;
            }

            ListNode(int val, ListNode next) {
                this.data = val;
                this.next = next;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = null;
            ListNode node = null;
            int carry = 0;
            while (l1 != null || l2 != null) {

                int num1 = l1 != null ? l1.data : 0;
                int num2 = l2 != null ? l2.data : 0;
                int sumNode = carry + num1 + num2;
                carry = sumNode / 10;

                int value = sumNode > 9 ? sumNode % 10 : sumNode;

                if (head == null) {
                    head = new ListNode();
                    head.data = value;
                    head.next = null;
                    node = head;
                } else {
                    node.next = new ListNode();
                    node = node.next;
                    node.data = value;
                    node.next = null;
                }

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            if (carry > 0) {
                node.next = new ListNode(carry, null);
            }
            return head;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Add two linked lists
    static Node addLists(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        Node result = null, temp = null;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            Node newNode = new Node(sum % 10);

            if (result == null) {
                result = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }

        return reverse(result);
    }

    // Utility to print list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void testAddTwoLinkedList() {
        // List1: 7 -> 5 -> 9 -> 4 -> 6
        Node l1 = new Node(7);
        l1.next = new Node(5);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(6);

        // List2: 8 -> 4
        Node l2 = new Node(8);
        l2.next = new Node(4);

        Node result = addLists(l1, l2);

        printList(result); // Expected: 7 -> 6 -> 0 -> 3 -> 0

        Node result2 = addByStackSolution(l1, l2);

        printList(result2); // Expected: 7 -> 6 -> 0 -> 3 -> 0
    }

    static Node addByStackSolution(Node l1, Node l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();

            Node newNode = new Node(sum % 10);
            newNode.next = result;
            result = newNode;

            carry = sum / 10;
        }

        return result;
    }
}
