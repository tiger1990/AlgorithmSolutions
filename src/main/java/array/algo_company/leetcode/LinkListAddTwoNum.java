package array.algo_company.leetcode;

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
                        new NodeTest.ListNode(9,
                                new NodeTest.ListNode(9, null)))));

        NodeTest.ListNode l3= new NodeTest().addTwoNumbers(l1, l2);

        System.out.println("  SUM ");
        while(l3.next != null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
        System.out.println(l3.val);
    }

    static class NodeTest {
        public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = null;
            ListNode node = null;
            int carry = 0;
            while (l1 != null || l2 != null) {

                int num1 = l1 != null? l1.val : 0;
                int num2 = l2 != null? l2.val : 0;
                int sumNode = carry + num1 + num2;
                carry = sumNode / 10;

                int value = sumNode > 9 ? sumNode % 10 : sumNode;

                if (head == null) {
                    head = new ListNode();
                    head.val = value;
                    head.next = null;
                    node = head;
                } else {
                    node.next = new ListNode();
                    node = node.next;
                    node.val = value;
                    node.next = null;
                }

                l1 = l1 != null ? l1.next: null;
                l2 = l2 != null ? l2.next: null;
            }
            if (carry > 0) {
                node.next = new ListNode(carry, null);
            }
            return head;
        }
    }
}
