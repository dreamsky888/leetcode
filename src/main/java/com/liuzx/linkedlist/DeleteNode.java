package com.liuzx.linkedlist;

/**
 * @Author: liuzx
 * @Date: 2019/10/25 17:04
 * @Description: 删除链表中的节点
 **/
public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
          node.val = node.next.val;
          node.next = node.next.next;
    }
}
