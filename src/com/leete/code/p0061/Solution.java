package com.leete.code.p0061;

/**
 * 题目
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * <p>
 * 思路
 */

/**
 * 思路
 * 先将链表闭合成环
 找到相应的位置断开这个环，确定新的链表头和链表尾
 */

/**
 * 体会：
 *
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode footer=head;
        int size=1;

        while (footer.next!=null){
            footer=footer.next;
            size++;
        }
        footer.next=head;

        int step = size- k % size - 1 ;
        ListNode new_tail = head;
        for (int i = 0; i < step; i++) {
            new_tail=new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next=null;

        return new_head;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
