package com.leetcode;

/**
 * @author Binbin Wang
 * @date 2018/9/5
 */
public class Test3 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        removeElements(head, 6);

        System.out.println(head.val);
        while(head.next != null) {
            System.out.println(head.next.val);
            head = head.next;
        }

    }


    public static ListNode removeElements(ListNode head, int val) {
        if (head.val == val) head = head.next;

        ListNode iterator = head;
        while(iterator.next != null) {
            if (iterator.next.val == val) {
                if (iterator.next.next != null) {
                    iterator.next = iterator.next.next;
                } else {
                    iterator.next = null;
                }
            }
            iterator = iterator.next;
        }
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
