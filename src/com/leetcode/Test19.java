package com.leetcode;

import java.util.ArrayList;
import java.util.List;


//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.

public class Test19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> nodes = new ArrayList();
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        if (nodes.size() == 1)
            return null;
        if (n == nodes.size()) {
            head = nodes.get(1);
            return head;
        }
        if (n == 1) {
            nodes.get(nodes.size() - n -1).next = null;
            return head;
        }
        nodes.get(nodes.size() - n -1).next = nodes.get(nodes.size() - n + 1);
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
