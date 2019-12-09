package com.liuzx.linklist;


/**
 * @Author: liuzx
 * @Date: 2019/11/26 15:06
 * @Description:
 **/
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getListLength(l1);
        int size2 = getListLength(l2);
        if (size1 < size2) {
            ListNode tmpNode = l1;
            l1 = l2;
            l2 = tmpNode;
        }
        ListNode root = new ListNode(0);
        root.next = l1;
        int add = 0;
        while (l2 != null || add == 1) {
            if(root.next==null){
                root.next = new ListNode(0);
            }
            int val = root.next.val + (l2 == null ? 0 : l2.val) + add;
            if (val >= 10) {
                val -= 10;
                add = 1;
            } else {
                add = 0;
            }
            root.next.val = val;
            if(l2!=null){
                l2 = l2.next;
            }
            root = root.next;
        }
        return l1;
    }

    private int getListLength(ListNode l1) {
        int length = 0;
        while (l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.new ListNode(2);
        l1.next = addTwoNumbers.new ListNode(4);
        ListNode l2 = addTwoNumbers.new ListNode(5);
        l2.next = addTwoNumbers.new ListNode(6);
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
