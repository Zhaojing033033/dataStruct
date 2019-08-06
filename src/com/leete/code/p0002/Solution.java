package com.leete.code.p0002;

/**
 * 2.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retListNode = new ListNode(0);

        sum(l1, l2, retListNode, 0);

        return retListNode.next;
    }

    public void sum(ListNode l1, ListNode l2, ListNode retNode, int carry) {
        int sum = 0;
        if (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            int sub = sum % 10;
            retNode.next =new ListNode(sub);
            int carry1 = sum / 10;

            sum(l1.next, l2.next, retNode.next, carry1);

        }

        if (l1 != null && l2 == null) {
            sum = l1.val+carry;
            int sub = sum % 10;
            int carry1 = sum / 10;
            retNode.next =new ListNode(sub);
            sum(l1.next, null, retNode.next, carry1);
        }

        if (l1 == null && l2 != null) {
            sum = l2.val+carry;
            int sub = sum % 10;
            int carry1 = sum / 10;
            retNode.next =new ListNode(sub);
            sum(null, l2.next, retNode.next, carry1);
        }

        if(l1 == null && l2 == null && carry !=0){
            retNode.next =new ListNode(carry);
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}