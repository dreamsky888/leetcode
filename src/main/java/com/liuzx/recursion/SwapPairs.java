package com.liuzx.recursion;

/**
 * @Author: liuzx
 * @Date: 2019/10/11 18:02
 * @Description:
 **/
public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondNode = head.next;
        ListNode newHead = secondNode.next;
        secondNode.next = head;
        head.next = swapPairs(newHead);
        return secondNode;
    }
}
