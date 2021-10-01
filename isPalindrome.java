import com.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.logging.Logger;

public class isPalindrome {
    public static class Solution {
        
        // public ListNode swapNodes(ListNode head, int k) {
        //     if (head == null || head.next == null) return head;
        //     int cnt = 0, newCnt = 0;
        //     ListNode p = head , dummy = new ListNode(0), q = null;
        //     dummy.next = head;

        //     while (p != null) {
        //         cnt++;
        //         p = p.next;
        //     }
            
        //     if (cnt % 2 == 1 && k == cnt / 2 + 1) return head; // 最中间一个的特殊处理
        //     else if (k > cnt / 2) // 处理后一半的情况
        //     return swapNodes(head, cnt - k + 1);

        //     p = dummy;
        //     while (newCnt < k) {
        //         newCnt++;
        //         p = p.next;
        //     }
        //     // newCnt == k

        //     q = p;
        //     while (newCnt < cnt - k + 1) {
        //         newCnt++;
        //         q = q.next;
        //     }
        //     // newCnt == cnt - K + 1
        //     int tmp = q.val;
        //     q.val = p.val;
        //     p.val = tmp;
        //     return dummy.next;
        // }

        
        // public ListNode oddEvenList(ListNode head) {
        //     if (head == null || head.next == null || head.next.next == null) return head;
        //     ListNode p = head, q = head.next, qhead = q;
        //     while (q != null && q.next != null) {
        //         p.next = q.next;
        //         p = p.next;
        //         q.next = p.next;
        //         q = q.next;
        //     }
        //     p.next = qhead;
        //     return head;
        // }
    
        
        // private int binarySearchinSortedArray(int [] arr, int target, int bgn, int end) {
        //     int mid;
        //     while (bgn < end) {
        //         mid = bgn + (end - bgn) / 2;
        //         if (arr[mid] == target) return mid;
        //         if (arr[mid] < target) {
        //             bgn = mid + 1;
        //         } else
        //         end = mid - 1;
        //     }
        //     if (bgn == end && arr[bgn] == target) return bgn;
        //     return -1;
        // }
        // public int search(int[] nums, int target) {
        //     return binarySearchinSortedArray(nums, target, 0, nums.length - 1);
        // }
        // public int numComponents(ListNode head, int[] nums) {
        //     if (nums.length == 1) return 1;
        //     return 0;
        // }

        
        // private int nextGreater(ListNode p, int val) {
        //     if (p == null) return 0;
        //     while (p != null) {
        //         if (p.val > val)
        //         return p.val;
        //         p = p.next;
        //     }
        //     return 0;
        // }
        
        // public int[] nextLargerNodes(ListNode head) {
        //     if (head == null) return null;
        //     if (head.next == null) return new int [] {0};
        //     ListNode p = head;
        //     int cnt = 0;
        //     Stack<Integer> stack = new Stack<Integer>();
        //     while (p != null) {
        //         stack.push(nextGreater(p.next, p.val));
        //         cnt++;
        //         p = p.next;
        //     }
        //     int [] result = new int[cnt];
        //     for (int i = cnt - 1; i >= 0; i--) {
        //         result[i] = stack.pop();
        //     }
        //     return result;
        // }
        
        // public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //     ListNode curr = list1, prev = null;
        //     int cnt = 0;
        //     while (cnt < a) {
        //         cnt++;
        //         prev = curr;
        //         curr = curr.next;
        //     }
        //     prev.next = list2;
        //     prev = prev.next;
        //     while (prev.next != null)
        //     prev = prev.next;
        //     while (cnt < b) {
        //         curr = curr.next;
        //         cnt++;
        //     }
        //     prev.next = curr.next;
        //     curr.next = null;
        //     return list1;
        // }
        
        // public int getDecimalValue(ListNode head) {
        //     if (head == null || (head.next == null && head.val == 0)) return 0;
        //     Set<Integer> set = new HashSet<>();
        //     int cnt = 0;
        //     ListNode p = head;
        //     while (p != null) {
        //         ++cnt;
        //         if (p.val == 1) 
        //         set.add(cnt);
        //         p = p.next;
        //     }
        //     int result = 0;
        //     for (Integer value : set) {
        //         result += Math.pow(2, cnt - value);
        //     }
        //     return result;
        // }

        // public ListNode removeElements(ListNode head, int val) {
        //     if (head == null) return head;
        //     ListNode dummy = new ListNode(-1);
        //     dummy.next = head;
        //     ListNode curr = dummy.next, prev = dummy;
        //     while (curr != null && curr.val == val) {
        //         curr = curr.next;
        //     }
        //     if (curr == null) return null;
        //     prev.next = curr;
        //     prev = curr;
        //     curr = curr.next;

        //     while (curr != null) {
        //         while (curr != null && curr.val == val) {
        //             curr = curr.next;
        //         }
        //         if (curr == null) {
        //             prev.next = null;
        //             return dummy.next;
        //         }
        //         while (curr != null && curr.val != val) {
        //             prev.next = curr;
        //             prev = curr;
        //             curr = curr.next;
        //         }
        //     }
        //     if (curr == null) {
        //         prev.next = null;
        //         return dummy.next;
        //     }
        //     return dummy.next;
        // }
        
        // private ListNode middleNode(ListNode head) {
        //     if (head == null || head.next == null) return head;
        //     if (head.next.next == null) return head.next;
        //     ListNode p = head, q = head;
        //     while (q.next != null) {
        //         p = p.next;
        //         q = q.next;
        //         if (q.next != null)
        //         q = q.next;
        //         else
        //         return p;
        //     }
        //     return p;
        // }

        // public boolean isPalindrome(ListNode head) {
        //     if (head == null || head.next == null) return true;
        //     StringBuilder firstHalf = new StringBuilder("");
        //     ListNode p = head, q = head;

        //     while (q != null && q.next != null) {
        //         firstHalf.append(Character.forDigit(p.val, 10)); 
        //         p = p.next;
        //         q = q.next.next;
        //     }
        //     if (q != null && q.next == null)
        //     p = p.next;

        //     int i = firstHalf.length() - 1;
        //     while (i >= 0) {
        //         if (p.val != Integer.parseInt(String.valueOf(firstHalf.charAt(i)))) 
        //         return false;
        //         p = p.next;
        //         i --;
        //     }
        //     return true;
        // }

        // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //     if (l1.next == null && l1.val == 0) return l2;
        //     else if (l2.next == null && l2.val == 0) return l1;

        //     int m = 0, n = 0;
        //     ListNode p = l1, q = l2;
        //     while (p != null && q != null) {
        //         m++;
        //         n++;
        //         p = p.next;
        //         q = q.next;
        //     }
                
        //     if (q != null) return addTwoNumbers(l2, l1);// 只处理 l1 >= l2 的情况
        //     while (p != null) {
        //         m++;
        //         p = p.next;
        //     }
            
        //     int [] res = new int[m];
        //     int pcnt = 0;
        //     p = l1;
        //     while (pcnt < m - n) {
        //         res[pcnt++] = p.val;
        //         p = p.next;
        //     }
            
        //     q = l2;
        //     while (pcnt < m) {
        //         res[pcnt++] = p.val + q.val;
        //         p = p.next;
        //         q = q.next;
        //     }
            
        //     int carry = 0, tmp = 0;
        //     for (int i = m - 1; i >= 0; i--) {
        //         if (carry + res[i] > 9) {
        //             tmp = carry + res[i];
        //             carry = tmp / 10;
        //             res[i] = tmp % 10;
        //         } else {
        //             res[i] = carry + res[i];
        //             carry = 0;
        //         }
        //     }

        //     ListNode result = l1;
        //     if (carry > 0) {
        //         ListNode newHead = new ListNode(carry);
        //         newHead.next = l1;
        //         result = newHead;
        //     }
            
        //     p = l1;
        //     m = 0;
        //     while (p != null) {
        //         while (res[m] == p.val) {
        //             m++;
        //             p = p.next;
        //         }
        //         if (res[m] != p.val) {
        //             p.val = res[m++];
        //             p = p.next;
        //         }
        //     }
        //     return result;
        // }

        // public ListNode[] splitListToParts(ListNode head, int k) {
        //     if (k == 1) return new ListNode [] {head};
        //     ListNode [] result = new ListNode [k];

        //     // get list length: cnt
        //     ListNode p = head;
        //     int cnt = 0;
        //     while (p != null) {
        //         cnt++;
        //         p = p.next;
        //     }
        //     if (cnt <= k) { // cnt <= k
        //         int m = 0;
        //         p = head;
        //         while (p != null) {
        //             result[m] = p;
        //             p = p.next;
        //             result[m++].next = null;
        //         }
        //         while (m < k) {
        //             result[m++] = null;
        //         }
        //         return result;
        //     }
        
        //     int [] nodeCnts = new int[k];
        //     int residual = cnt % k;
        //     for (int i = 0; i < k; i++) 
        //     nodeCnts[i] = cnt / k + (residual-- > 0 ? 1 : 0);

        //     int idx = 0;
        //     p = head;
        //     cnt = 0;
        //     ListNode prev = head;
        //     ListNode eachHead = head;
        //     for (int i = 0; i < k; i++) {
        //         eachHead = p;
        //         while (cnt < nodeCnts[i]) {
        //             cnt++;
        //             prev = p;
        //             p = p.next;
        //         }
        //         prev.next = null;
        //         result[i] = eachHead;
        //         cnt = 0; // 不要忘记了这一句
        //     }
        //     return result;
        // }

        // public class Node {
        //     public int val;
        //     public Node prev;
        //     public Node next;
        //     public Node child;
        // };
        // private Stack<Node> nextStack = new Stack<Node>();
        // Node dummy = new Node(0);
        // Node prev = null, curr = null, next = null;

        // private void handleCurrNode( Node curr) {
        //     if (curr.child != null) {
        //         if (next != null)
        //         nextStack.push(next);
        //         prev = curr;
        //         curr = curr.child;
        //         curr.prev = prev;
        //         next = curr.next;
        //     } else if (next != null) {
        //         prev = curr;
        //         curr = curr.next;
        //         next = next.next;
        //     }
        // }
        
        // public Node flatten(Node head) {
        //     if (head == null) return head;
        //     Node prev = null;
        //     Node curr = head;
        //     Node next = curr.next;
        //     while (curr.child == null && next != null) {
        //         prev = curr;
        //         curr = next;
        //         next = next.next;
        //     }
        //     if (curr.child == null && next == null) return head;
        //     if (curr.child != null) {
        //         next = curr.next;
        //         if (next != null) {
        //             curr.next.prev = null;
        //         }
        //         if (curr.child.child == null) {
        //             curr.next = curr.child;
        //             curr.child.prev = curr;
        //             curr.child = null;
        //         } else {
        //             Node tmp = flatten(curr.child);
        //             curr.next = tmp;
        //             tmp.prev = curr;
        //             curr.child = null;
        //         }
        //         prev = curr;
        //         curr = flatten(curr.next);
        //         while (curr != null) { 
        //             prev = curr;
        //             curr = curr.next;
        //         }
        //         curr = prev;
        //         if (next != null) {
        //             Node aaa =  flatten(next);
        //             curr.next = aaa;
        //             aaa.prev = curr;
        //         }
        //     }
        //     return head;
        // }
        

    }    
    public static void main(String[] args) {
        Solution s = new Solution();
        // int [] a = new int [] {1, 2, 3, 4, 5, 6, -1, -1, -1, 7, 8, 9, 10, -1, -1, 11, 12}; 
        int [] a = new int [] {1, -1, 2, -1, 3, -1}; 

        Node root = new Node(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        Node p = s.flatten(root), prev = null;

        // while (p != null) {
        //     System.out.println(p.val + ", ");
        //     prev = p;
        //     p = p.next;
        // }
        // System.out.println("reversed: \n ");
        // p = prev;
        // while (p != null) {
        //     System.out.println(p.val + ", ");
        //     if (p.child != null) {
        //         System.out.println("p.val: " + p.val);
        //         System.out.println("p.child.val: " + p.child.val);
        //     }
        //     prev = p;
        //     p = p.prev;
        // }
    }
}