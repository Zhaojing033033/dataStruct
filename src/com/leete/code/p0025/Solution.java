package com.leete.code.p0025;

/**
 * 题目
 */

/**
 * 思路
 */

/**
 * 体会：
 *
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(6);


        ListNode listNode = new Solution().reverseKGroup(l1,l1.next.next.next.next, 4);
        while (listNode!=null){
            System.out.println(listNode.val+" -->");
            listNode=listNode.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumyHead=new ListNode(-1);
        dumyHead.next=head;
        ListNode l=dumyHead,r=dumyHead;
        int i=0;
        while (r!=null && r.next != null){
            r=r.next;
            i++;
            if(i==k || r.next==null){
                reverseKGroup(l,r,i);
                l=r;
                i=0;
            }

        }
        return dumyHead.next;
    }

    public ListNode reverseKGroup(ListNode l, ListNode r, int i) {
        ListNode listNode = new ListNode(-1);
        listNode=l;
        for (int j = 1; j < i; j++) {
            //将该组的第一个节点挂到该组的最后一个节点上
            ListNode next = l.next;
            l.next=next.next;
            next.next=r.next;
            r.next=next;
            //将右指针移动到该组最后一个节点
            r=next;
        }
        return listNode.next;
    }


}
 class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }