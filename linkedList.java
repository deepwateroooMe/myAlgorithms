import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class linkedList {
    public static class Solution {

        // public ListNode removeZeroSumSublists(ListNode head) {
        //     if (head.next == null) return head;
        //     ListNode p = head;
        //     int cnt = 0;
        //     while (p != null) {
        //         ++cnt;
        //         p = p.next;
        //     }
        //     int [] vals = new int[cnt];
        //     int n = cnt;
        //     p = head;
        //     cnt = 0;
        //     while (p != null) {
        //         vals[cnt++] = p.val;
        //         p = p.next;
        //     }
        //     int i = 0;
        //     int sum = 0;
        //     while (i < n && vals[i] >= 0) {
        //         ++i;
        //         sum += vals[i];
        //     }
        //     if (sum == vals[i]) i = i + 1;
        //     if (i == n) return head;
        //     return null;
        // }

        // private boolean inarray (int [] arr, int val) {
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] == val) return true;
        //     }
        //     return false;
        // }
        // public int numComponents(ListNode head, int[] nums) {
        //     if (head.next == null) return 1;
        //     ListNode p = head;
        //     int res = 0;
        //     boolean inarray = false;
        //     while (p != null) {
        //         while (p != null && inarray(nums, p.val)) {
        //             p = p.next;
        //             inarray = true;
        //         }
        //         if (inarray) {
        //             res += 1;
        //             inarray = false;
        //         }
        //         while (p != null && !inarray(nums, p.val)) p = p.next;
        //     }
        //     return res;
        // }

        // private ListNode oriHead;
        // private int count;
        // /** @param head The linked list's head.
        //     Note that the head is guaranteed to be not null, so it contains at least one node. */
        // public Solution(ListNode head) {
        //     oriHead = head;
        //     ListNode p = head, prev = p;
        //     int cnt = 0;
        //     while (p != null) {
        //         ++cnt;
        //         prev = p;
        //         p = p.next;
        //     }
        //     count = cnt;
        //     prev.next = head;
        // }
        // /** Returns a random node's value. */
        // public int getRandom() {
        //     Random rand = new Random();
        //     int tmp = rand.nextInt(count);
        //     int cnt = 0;
        //     ListNode p = oriHead;
        //     while (cnt < tmp) {
        //         cnt++;
        //         p = p.next;
        //     }
        //     return p.val;
        // }

        private List<Integer> l;
        private ListNode removePartsFromList(ListNode h, int i, int j) {
            int cnt = 0;
            ListNode p = h, prev = p, firstTail = p;
            if (i > 0) {
                while (p != null && cnt < i) {
                    ++cnt;
                    prev = p;
                    p = p.next;
                }
                firstTail = prev;
            } 
            cnt = 0;
            while (p != null && cnt < j - i) {
                ++cnt;
                prev = p;
                p = p.next;
            }
            prev.next = null;
            // if (i > 0) firstTail.next = p;
            // else h = p;
            if (i > 0) firstTail.next = removeZeroSumSublists(p);
            else h = removeZeroSumSublists(p);

            // System.out.println("\nlist:");
            // if (p != null)
            // p.printList(p);
            // h.printList(h);
            int tmp = j;
            if (j <= arr.length-1) {
                for (int x = i; x < arr.length; x++) {
                    if (x < tmp) arr[x] = arr[j];
                    ++j;
                    if (j >= arr.length) arr[x] = 1001;
                }
            }
            return h;
            //removeZeroSumSublists(h);
        }
        private void removeZeroSumFromArr(int [] arr) {
            int n = arr.length;
        }
        private int [] arr;
        public ListNode removeZeroSumSublists(ListNode head) {
            if (head == null || head.next == null) return head;
            l = new ArrayList<>();
            ListNode p = head, prev = p;
            while (p != null) {
                l.add(p.val);
                p = p.next;
            }
            int n = l.size();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = l.get(i);
            }
            int i = 0, j = 0, x = 0, sum = 0;
            int cnt = 0;
            while (i < l.size() && l.get(i) > 0) ++i;
            if (i == n) return head;
            if (i == n-1) {
                j = n;
                x = i-1;
                sum = l.get(i);
                while (sum <= 0 && x >= 0) {
                    sum += l.get(x);
                    --x;
                }
            }
            j = i+1;
            sum += l.get(i);
            while (sum <= 0 && j < l.size()) {
                sum += l.get(j);
                ++j;
            }
            if (j - i > 1 && (j == l.size() || sum == l.get(j))) {
                cnt = 0;
                while (cnt < j - i && i < l.size()) {
                    l.remove(i);
                }
                head = removePartsFromList(head, i, j);
            } else {
                x = i-1;
                sum -= l.get(j);
                while (sum <= 0 && x >= 0) {
                    sum += l.get(x);
                    --x;
                }
                if (sum > 0 && sum < l.get(x)) {
                    j = i + 1;
                    x = i-1;
                    sum = l.get(i);
                    while (sum <= 0 && j >= 0) {
                        --x;
                        sum += l.get(x);
                    }
                }
                if (i - x > 1 && (x < 0 || sum == l.get(x))) {
                    cnt = 0;
                    while (cnt < j - x - 1) {
                        l.remove(x+1);
                    }
                    head = removePartsFromList(head, x+1, j);
                } 
            }
            System.out.println("");
            System.out.println("l.size(): " + l.size());
            for ( i = 0; i < l.size(); ++i) 
            System.out.print(l.get(i) + ", ");
            System.out.print("\n");

            return head;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {1, 2, -3, 3, -2}; 

        ListNode head = new ListNode(a[0]);
        head.buildList(head, a);
        head.printList(head);

        ListNode res = s.removeZeroSumSublists(head);
        res.printList(res);
    }
}