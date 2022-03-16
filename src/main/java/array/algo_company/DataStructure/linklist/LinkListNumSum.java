package array.algo_company.DataStructure.linklist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListNumSum {

    public static void main(String... args){
//        LinkedList<Integer> list1 = new LinkedList();
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//        list1.add(9);
//
//        LinkedList<Integer> list2 = new LinkedList();
//        list2.add(9);
//        list2.add(9);
//        list2.add(9);
//        list2.add(9);
//        printReverseSum(list1,list2);


//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        ListNode listNode = addTwoNumbers(l1, l2);


//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//       ListNode listNode = addTwoNumbers(l1, l2);


//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(2);
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoLists(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static ListNode addTwoLists(ListNode first, ListNode second)
    {
        // res is head node of the resultant list
        ListNode head = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        // while both lists exist
        while (first != null || second != null) {
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new ListNode(sum);

            // if this is the first node then set
            // it as head of the resultant list
            if (head == null) {
                head = temp;
            }

            // If this is not the first
            // node then connect it to the rest.
            else {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        // return head of the resultant list
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int remainder = 0;

        ListNode head = null;
        ListNode tail = null;
        while(l1 != null || l2 != null){

            int num1 = 0;
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            int num2 = 0;
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + remainder;
            remainder = sum/10;
            int partToAdd = sum % 10;
            if(head == null){
                ListNode listNode = new ListNode(partToAdd);
                head = listNode;
            }else{

                ListNode nextNode =  new ListNode(partToAdd);
                if(tail == null){
                    tail = nextNode;
                    head.next = tail;
                    continue;
                }
                tail.next = nextNode;
                tail = nextNode;
            }
        }
        if(remainder > 0){
            ListNode node =  new ListNode(remainder);
            if(tail == null){
                tail = node;
                head.next = tail;
            }else tail.next = node;
        }
        return head;
    }

    private static void printReverseSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        Iterator itr1 = list1.iterator();
        Iterator itr2 = list2.iterator();
        int remainder = 0;

        LinkedList<Integer> newList = new LinkedList();
        while(itr1.hasNext() || itr2.hasNext()){

            int num1 = 0;
            if(itr1.hasNext()){
                num1= (int) itr1.next();
            }

            int num2 = 0;
            if(itr2.hasNext()){
                num2 = (int) itr2.next();
            }

            int sum = num1 + num2 + remainder;
            remainder = sum/10;
            int partToAdd = sum % 10;
            newList.add(partToAdd);
        }
         if(remainder > 0){
             newList.add(remainder);
         }
        //new link list has value
        for(Iterator iterator = newList.iterator();iterator.hasNext();){

            System.out.print(iterator.next());
        }
    }
}
