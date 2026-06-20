package array.algo_company.leetcode;

import java.util.PriorityQueue;

public class MergeKListNode {

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

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        //sorted in ascending order.
        //[
        // [1,4,5],
        // [1,3,4],
        // [2,6]
        // ]

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] nodeArray = new ListNode[]{listNode1, listNode2, listNode3};

        optimizedMergeKLists(nodeArray);
    }

    public static ListNode optimizedMergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a,b) -> a.val - b.val
        );
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode head1 = null;
        ListNode head2 = null;


        for (ListNode node : lists) {
            if (head1 == null) {
                head1 = node;
            } else {
                head2 = node;
            }

            if (head1 != null && head2 != null) {
               head1 = mergeKLists2(head1, head2);
            }
        }
        return head1;
    }

    public static ListNode mergeKLists2(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }

        return dummy.next;
    }
}
