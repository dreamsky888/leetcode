package com.liuzx.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 11:37
 * @Description:
 **/
public class HasCycle {

    /**
     * @Author liuzx
     * @Date 2019/10/28 14:10
     * @Description 哈希表
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }

}
