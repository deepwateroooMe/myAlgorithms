import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class mergeKLists {
    public static class Solution {
        public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode result;
            if (l1.val < l2.val) {
                result = l1;
                l1 = l1.next;
                result.next = null;
            } else {
                result = l2;
                l2 = l2.next;
                result.next = null;
            }
            ListNode curr = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                    curr.next = null;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                    curr.next = null;
                }
            }
            if (l1 == null && l2 == null)
                return result;
            l1 = (l1 == null) ? l2 : l1;
            curr.next = l1;
            return result;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);     // dummy List ~!
            for (ListNode p = head; l1 != null || l2 != null; p = p.next) {
                int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                if (val1 < val2) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
            }
            return head.next;
        }

        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists.size() == 0) return null;
            ListNode p = lists.get(0);  // Time Limit Exceeded
            for (int i = 1; i < lists.size(); i++) {
                p = mergeTwoLists(p, lists.get(i));
            }
            return p;
        }

        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists.size() == 0) return null;
            if (lists.size() == 1) return lists.get(0);
            if (lists.size() == 2) return mergeTwoLists(lists.get(0), lists.get(1));
            return mergeTwoLists((mergeKLists(lists.subList(0, lists.size() / 2))),
                                 (mergeKLists(lists.subList(lists.size() / 2, lists.size()))));
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
