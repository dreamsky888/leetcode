package com.liuzx.linkedlist;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 13:41
 * @Description: 回文链表
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        for (ListNode tmpNode = head; tmpNode != null; tmpNode = tmpNode.next) {
            length++;
        }
        int halfSize = length / 2;
        ListNode leftNode = null;
        ListNode rightNode = head;
        for (int i = 0; i < halfSize; i++) {
            ListNode tmpNode = rightNode.next;
            rightNode.next = leftNode;
            leftNode = rightNode;
            rightNode = tmpNode;
        }
        if (length % 2 == 1) {
            rightNode = rightNode.next;
        }
        while (leftNode != null) {
            if (leftNode.val != rightNode.val) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return true;
    }
}
