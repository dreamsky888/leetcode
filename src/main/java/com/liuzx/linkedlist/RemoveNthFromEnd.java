package com.liuzx.linkedlist;

/**
 * @Author: liuzx
 * @Date: 2019/10/25 17:14
 * @Description:
 **/
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        ListNode preNode = virtualNode;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            preNode = preNode.next;
            head = head.next;
        }
        preNode.next = preNode.next.next;
        return virtualNode.next;
    }
}
