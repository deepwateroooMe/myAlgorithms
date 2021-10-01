package com;

public class ListNode {
    // public int val;
    // public ListNode next;
    // public ListNode(int x) {
    //     val = x;
    //     next = null;
    // }
    public ListNode pp;


    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    
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

    public void buildList(ListNode head, int [] a, int val) {
        ListNode curr = head;
        ListNode tmp;
        int cnt = 1;
        while (cnt <= a.length-1) {
            tmp = new ListNode(a[cnt++]);
            curr.next = tmp;
            curr = curr.next;
            if (tmp.val == val) pp = tmp;
        }
        if (head.val == val) pp = head;
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
