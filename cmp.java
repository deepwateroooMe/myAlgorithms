import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        // public int countEven(int num) {
        //     int cnt = 0;
        //     for (int i = num; i >= 1; i--) {
        //         if (getSum(i) % 2 == 0)
        //             cnt++;
        //     }
        //     return cnt;
        // }
        // int getSum(int v) {
        //     int ans = 0;
        //     while (v > 0) {
        //         ans += v % 10;
        //         v /= 10;
        //     }
        //     return ans;
        // }

        // public ListNode mergeNodes(ListNode head) {
        //     List<Integer> ll = new ArrayList<>();
        //     ListNode p = head.next, pre = null, cur = null, next = null;
        //     int v = 0;
        //     while (p != null) {
        //         if (p.val == 0) {
        //             ll.add(v);
        //             v = 0;
        //         } else
        //             v += p.val;
        //         p = p.next;
        //     }
        //     ListNode ans = new ListNode(ll.get(0));
        //     p = ans;
        //     for (int i = 1; i < ll.size(); i++)  {
        //         p.next = new ListNode(ll.get(i));
        //         p = p.next;
        //     }
        //     return ans;
        // }

        public long coutPairs(int[] a, int k) { // tle： 92/115 passed: 在想这个题目是否还含分解质因子、动态规划之类的？为什么会超时呢？
            long n = a.length, cnt = 0, recnt = 0; // test case 太不友好了，出个bug就是死大死大一个case，让别人怎么debug呢，从哪里下手呢？！！！
            if (k == 1) return n * (n-1)/2;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(a[0], 1);
            for (int i = 1; i < n; i++) {
                System.out.println("\n i: " + i);
                
                if (a[i] % k == 0) {
                    recnt++;
                    cnt += n-1;
                    // m.put(a[i], m.getOrDefault(a[i], 0) + 1);
                    System.out.println("cnt: " + cnt);
                    System.out.println("recnt: " + recnt);
                    continue;
                }
                for (Integer key : m.keySet()) {
                    if ((long)key * a[i] % k == 0) {
                        cnt += m.get(key);
                    }
                }
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
                System.out.println("cnt: " + cnt);
                System.out.println("recnt: " + recnt);
            }
            return cnt - recnt * (recnt-1) / 2;
        }

        // public String repeatLimitedString(String t, int lt) { // tle
        //     int [] cnt = new int [26];
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) 
        //         cnt[s[i]-'a']++;
        //     String ans = "";
        //     int i = 25, j = -1;
        //     while (i >= 0) {
        //         while (i >= 0 && cnt[i] == 0) i--;
        //         if (i < 0) return ans;
        //         if (ans.length() == 0 || ans.charAt(ans.length()-1) != (char)('a'+i)) {
        //             if (cnt[i] <= lt) {
        //                 ans += ("" + (char)('a'+i)).repeat(cnt[i--]);
        //                 if (j == -1) i--;
        //                 else 
        //                     i = j;
        //             } else {
        //                 ans += ("" + (char)('a'+i)).repeat(lt);
        //                 cnt[i] -= lt;
        //                 if (i >= 1) {
        //                     // int j = i-1;
        //                     if (j == -1) j = i-1;
        //                     while (j >= 0 && cnt[j] == 0) j--;
        //                     if (j < 0) return ans;
        //                     ans += (char)('a'+j);
        //                     cnt[j]--;
        //                 } else if (i == 0) return ans;
        //             }
        //         } else if (ans.charAt(ans.length()-1) == (char)('a'+i)) {
        //             if (j == -1) {
        //                 j = i-1;
        //                 while (j >= 0 && cnt[j] == 0) j--;
        //                 if (j < 0) return ans;
        //                 ans += (char)('a'+j);
        //                 cnt[j]--;
        //             }
        //         }
        //     }
        //     // Queue<ob> q = new PriorityQueue<>((a, b)->b.c - a.c);
        //     // for (int i = 25; i >= 0; i--)
        //     //     if (cnt[i] > 0)
        //     //         q.offer(new ob((char)('a'+i), cnt[i]));
        //     // while (!q.isEmpty()) {
        //     //     ob cur = q.poll();
        //     //     if (ans.length() == 0 || ans.charAt(ans.length()-1) != cur.c) {
        //     //         if (cur.cnt <= lt)
        //     //             ans += (""+ cur.c).repeat(cur.cnt);
        //     //         else {
        //     //             ans += (""+ cur.c).repeat(lt);
        //     //             cur.cnt -= lt;
        //     //             q.offer(cur);
        //     //         }
        //     //     } else if (ans.charAt(ans.length()-1) == cur.c) {
        //     //         if (q.isEmpty()) return ans;
        //     //         ob next = q.poll();
        //     //         ans += next.c;
        //     //         if (next.cnt > 1) {
        //     //             next.cnt--;
        //     //             q.offer(next);
        //     //         }
        //     //         q.offer(cur);
        //     //     }
        //     // }
        //     return ans;
        // }
        public String repeatLimitedString(String t, int lt) { // bug 144/150 leetcode is too bad don't show wrong test case to users......
            int [] cnt = new int [26];
            int n = t.length();
            // if (lt == 1) {
            //     StringBuilder sb = new StringBuilder();
            //     for (int i = 25; i >= 0; i--) {
            //         if (cnt[i] > 0)
            //             sb.append((char)('a'+i));
            //     }
            //     return sb.toString();
            // }
            if (t.chars().distinct().count() == 1)
                return n >= lt ? t.substring(0, lt) : (""+t.charAt(0)).repeat(lt);
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) 
                cnt[s[i]-'a']++;
            String ans = "";
            int i = 25, j = -1;
            System.out.println(Arrays.toString(cnt));
            while (i >= 0) {
                System.out.println("\n i: " + i);
                while (i >= 0 && cnt[i] == 0) i--;
                if (i < 0) return ans;
                System.out.println("i: " + i);
                if (ans.length() == 0 || ans.charAt(ans.length()-1) != (char)('a'+i)) {
                    if (cnt[i] <= lt) {
                        ans += ("" + (char)('a'+i)).repeat(cnt[i]);
                        cnt[i] = 0;
                        System.out.println("j: " + j);
                        if (j == -1) {
                            i--;
                            // continue;
                        } else 
                            i = j;
                    } else {
                        ans += ("" + (char)('a'+i)).repeat(lt);
                        cnt[i] -= lt;
                        // if (i >= 1) {
                        //     if (j == -1) j = i-1;
                        //     while (j >= 0 && cnt[j] == 0) j--;
                        //     if (j < 0) return ans;
                        //     ans += (char)('a'+j);
                        //     cnt[j]--;
                        // } else if (i == 0) return ans;
                    }
                } else if (ans.charAt(ans.length()-1) == (char)('a'+i)) {
                    // System.out.println("i: " + i);
                    // System.out.println("ans.charAt(ans.length()-1): " + ans.charAt(ans.length()-1));
                    if (i == 0) return ans;
                    if (j == -1) 
                        j = i-1;
                    while (j >= 0 && cnt[j] == 0 || j == i) j--;
                    if (j < 0) return ans;
                    // System.out.println("j: " + j);
                    // System.out.println("(char)('a'+j): " + (char)('a'+j));
                    ans += (char)('a'+j);
                    // System.out.println("ans: " + ans);
                    cnt[j]--;
                    // System.out.println("cnt[j]: " + cnt[j]);
                }
                // System.out.println(Arrays.toString(cnt));
                // System.out.println("ans;: " + ans);
            }
            return ans;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // "yxxvvuvusrrqqppppoonliihgfeeddcbba"
        // "yxxvvuvusrrqqppopponliihgfeeddcbba"        
            // yxxvvuvusrrqqppopponliihgfeeddcbba
            // String a = "cczazcc";
        // String a = "aababab";
        // String a = "cczazcc";
        // String a = "pdprlxqryxdirdr";
        String a = "robnsdvpuxbapuqgopqvxdrchivlifeepy";

        String r = s.repeatLimitedString(a, 2);
        System.out.println("r: " + r);

        // // int [] a = new int [] {1, 2, 3, 4};
        // // int []  a = new int []  {3, 2, 6, 1, 8, 4, 1};
        // // int [] a = new int [] {3, 9, 6, 5};
        // int []  a = new int []  {5, 9, 5, 5, 10, 9, 2, 6, 7};
        // System.out.println(Arrays.toString(a));

        // long r = s.coutPairs(a, 2);
        // System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
