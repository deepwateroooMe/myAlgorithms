package com;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void buildList(ListNode head, int [] a) {
        ListNode curr = head;
        ListNode tmp;
        int cnt = 1;
        while (cnt <= a.length-1) {
            tmp = new ListNode(a[cnt++]);
            curr.next = tmp;
            curr = curr.next;
        }
    }

    public void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + ", ");
            tmp = tmp.next;
        }
        System.out.println("");
    }
}
