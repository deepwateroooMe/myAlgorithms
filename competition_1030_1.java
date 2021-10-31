import com.TreeNode;

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

        // public String kthDistinct(String[] arr, int k) {
        //     int cnt = 0, n = arr.length;
        //     Map<String, Integer> m = new HashMap<>(); // string ,idx
        //     for (int i = 0; i < n; i++) 
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     String ans = "";
        //     for (int i = 0; i < n; i++) 
        //         if (m.get(arr[i]) == 1) {
        //             cnt += 1;
        //             if (cnt == k) return arr[i];
        //         }
        //     return "";
        // }


        // // dfs
        // private void getAllPos(int [] pos, int [][] dirs, Set<Integer> vis) { // 最有效的思考都是在比赛的时候进行的，所以要多多参赛！！
        //  // private Set<Integer> getAllPos(int [] pos, int [][] dirs, Set<Integer> vis) {
        //     int x = pos[0]-1, y = pos[1]-1; // reset from parent func
        //     vis.add(x*n +y);
        //     for (int [] d : dirs) {
        //         int i = x + d[0], j = y + d[1];
        //         if (i < 0 || i >= n || j < 0 || j >= n || vis.contains(i*n+j)) continue;
        //         vis.add(i * n + j);
        //         dfs(new int [] {i, j}, dirs, vis);
        //     }
        // }
        // int n = 8;
        // public int countCombinations(String[] pieces, int[][] positions) { // 因为只有三种，所以也可以用数学方法更简单
        //     int m = pieces.length, range = (1 << n); // 把两种简单情况先过滤掉
        //     if (m <= 2) {
        //         if (m == 1) {
        //             int [] pos = positions[0];
        //             Set<Integer> vis = new HashSet<>();
        //             int x = pos[0]-1, y = pos[1]-1;
        //             vis.add(x*n +y);
        //             int [][] d = null;
        //             if (pieces[0].equals("rook")) d = rook;
        //             else if  (pieces[0].equals("queen")) d = queen;
        //             else d = bishop;
        //             getAllPos(pos, d, vis);
        //             return vis.size();
        //         }
        //         for (int i = 0; i < m; i++) { // 两种大小相乘，再减去交差位置个数相乘
    
        //         }
        //     }
        //     int [][] rook = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //     int [][] queen = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        //     int [][] bishop = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        //     int x = positions[0]-1, y = positions[1]-1;
        //     int rb = 1, qb = 64, bb = 64*64, cur = 0;
        //     Map<String, Integer> map = new HashMap<>(); // 只处理n == 3 n == 4 的情况
        //     map.put("rook", rb);   // a
        //     map.put("queen", qb);  // b
        //     map.put("bishop", bb); // c
        //     // integer represent state: idx1 * 64^0 + idx2 * 64^1 + idx3 * 64^2
        //     Map<Integer, Set<Integer>> dp = new HashMap<>();
        //     for (int i = 0; i < m; i++) {
        //         int [] p = positions[i];
        //         cur += ((p[0]-1)*n + p[1]-1)*map.get(pieces[i]);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     Set<Integer> vis = new HashSet<>();
        //     Set<Integer> sn = new HashSet<>();
        //     vis.add(cur);
        //     int pre = 0;
        //     while (vis.size() != pre) {
        //         pre = vis.size();
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int cur = q.poll();
        //             int c = cur / bb, b = cur / bb / qb, c = cur / bb % qb;
        //             int ci = c / n, cj = c % n, bi = b / n, bj = b % n, ci = c / n, cj = c % n;
        //             for (int [] dr : rook) { // 最好过滤出板上到底有几样东西
        //                 for (int [] dq : queen) {
        //                     for (int [] db : bishop) {
        //                 }
        //                 }
        //             }
        //         }
        //     }
        // }


        // public int maxTwoEvents(int[][] events) {  
        //     int n = events.length, maxSeenVal = 0;     // for any timestamp - find max of values to left and max of values to right
        //     Arrays.sort(events, (a,b) -> a[1] - b[1]); // Sort by end time - to know what events happened previously
        //     TreeMap<Integer, Integer> leftMaxSeen = new TreeMap<>();
        //     for (int [] event : events) {
        //         int eventVal = event[2];
        //         if (eventVal >= maxSeenVal) {
        //             maxSeenVal = eventVal;
        //             leftMaxSeen.put(event[1], maxSeenVal); // save maxSeenVal event value seen so far at END timestamp
        //         }
        //     }
        //     // Sort by start time but in descending order - as we parse events and store max value of future events to current event start timestamp
        //     Arrays.sort(events, (a,b) -> b[0] - a[0]);
        //     int ans = 0, maxSeenRight = 0;
        //     for (int [] event : events) {
        //         int eventVal = event[2];
        //         if (eventVal >= maxSeenRight) {
        //             maxSeenRight = eventVal;
        //             Integer maxOnLeftKey = leftMaxSeen.floorKey(event[0] - 1);
        //             if (maxOnLeftKey != null)
        //                 ans = Math.max(ans, leftMaxSeen.get(maxOnLeftKey) + maxSeenRight);
        //         }
        //     }
        //     return Math.max(maxSeenVal, ans); // 有一种单个事件得最大值的情况不能漏掉
        // }
        // public int maxTwoEvents(int[][] events) {
        //     int result = 0, maxOfCompletedEvents = 0;
        //     Arrays.sort(events, (x,y) -> x[0] - y[0]);   // Sort by Start time
        //     PriorityQueue<int[]> inProgressQueue = new PriorityQueue<>((x,y)->x[1]-y[1]); // sorted by end time
        //     for (int[] currentEvent : events) {
        //         while (!inProgressQueue.isEmpty() && inProgressQueue.peek()[1] < currentEvent[0])
        //             maxOfCompletedEvents = Math.max(maxOfCompletedEvents, inProgressQueue.poll()[2]);
        //         result = Math.max(result, maxOfCompletedEvents + currentEvent[2]);
        //         inProgressQueue.offer(currentEvent);
        //     }
        //     return result;
        // } // binary Search should be added here too
        // public int maxTwoEvents(int[][] events) {  // [startTimei, endTimei, valuei] 从首尾两端找的思路是对的
        //     int n = events.length, max = 0;
            // int [] pre = new int [n]; // 你在手动纪录这些东西，但是你纪录的这些信息不全，或不是最简洁的解题方案
            // int [] suf = new int [n];
            // for (int i = 0; i < n; i++) {
            //     if (events[i][2] > max) {
            //         max = events[i][2];
            //         maxIdx = i;
            //     } else pre[i] = (i == 0 ? 0 : pre[i-1]);
            //     pre[i] = maxIdx;
            // }
            // System.out.println(Arrays.toString(pre));
            // max = 0; maxIdx = n-1;
            // for (int i = n-1; i >= 0; i--) {
            //     if (events[i][2] > max) {
            //         max = events[i][2];
            //         maxIdx = i;
            //     } 
            //     suf[i] = maxIdx;
            // }
            // System.out.println(Arrays.toString(suf));
            // // Queue<int []> q = new PriorityQueue<>((a, b)->a[2] != b[2] ? b[2] - a[2] : a[1] - b[1]);
            // // q.offer(events[0]);
            // // max = 0;
            // // for (int i = 1; i < n; i++) {
            // //     System.out.println("\n i: " + i);
            // //     int [] top = q.peek();
            // //     while (i < n && events[i][1] == top[1]) q.offer(events[i++]);
            // //     if (suf[i-1] >= i && events[suf[i-1]][0] > q.peek()[1]) {
            // //         max = Math.max(max, q.peek()[2] + events[suf[i-1]][2]);
            // //     }
            // // }
            // for (int i = 1; i < n-1; i++) {
            //     if (pre[i] <= suf[i]) {
            //         if (events[pre[i]][1] < events[suf[i]][0])
            //             max = Math.max(max, events[pre[i]][2] + events[suf[i]][2]);
            //         int j = i;
            //         while (j < n-1 && suf[j] == suf[j+1]) j++;
            //         j++;
            //         while (j < n && events[pre[i]][1] >= events[suf[j]][0]) j++;
            //         if (j < n) 
            //             max = Math.max(max, events[pre[i]][2] + events[suf[j]][2]);
            //     }
            //     // else {
            //     if (pre[i-1] < suf[i] && events[pre[i-1]][1] < events[suf[i]][0])
            //         max = Math.max(max, events[pre[i-1]][2] + events[suf[i]][2]);
            //     if (pre[i] < suf[i+1] && events[pre[i]][1] < events[suf[i+1]][0])
            //         max = Math.max(max, events[pre[i]][2] + events[suf[i+1]][2]);
            // }
            // // }
            // return max;
        // }


        // private int getCnt(String t) {  // tle tle tle 这道题基本属于正常发挥，平时对preprocess的地方比较薄弱
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0, j = n-1;
        //     while (i < n && s[i] != '|') i++;
        //     while (j >= 0 && s[j] != '|') j--;
        //     if (j < i) return 0;
        //     int ans = 0;
        //     while (i <= j) {
        //         if (s[i] == '*') {
        //             ans++;
        //         } 
        //         i++;
        //     }
        //     return ans;
        // }
        // public int[] platesBetweenCandles(String t, int[][] queries) { // 需要preprocess cnt[i][j] 把所有的可能性全数出来备用，或要用时数一次并设下来备用
        //     int n = t.length(), m = queries.length;
        //     List<int []> q = new ArrayList<>(); // 这里看来，离线思维、离线算法深入人心，可惜这里用处不大
        //     for (int i = 0; i < m; i++) 
        //         q.add(new int [] {i, queries[i][0], queries[i][1]});
        //     Collections.sort(q, (a, b)->a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        //     int [] ans = new int [m];
        //     for (int i = 0; i < m; i++) {
        //         int [] cur = q.get(i);
        //         String cs = t.substring(cur[1], cur[2]+1);
        //         ans[cur[0]] = getCnt(cs);
        //     }
        //     return ans;
        // } // presum 部分我还没有写，所以对字符串类的presum preprocessing 写不出来不足为奇, good good study, day dap up~~!!
        public int[] platesBetweenCandles(String t, int[][] queries) { 
            int n = t.length();
            int [] sum = new int [n+1];
            int [] pre = new int [n+1], suf = new int [n+1];
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                sum[i+1] = sum[i] + (s[i] == '|' ? 1 : 0);
                pre[i+1] = s[i] == '|' ? i : pre[i];
            }
            for (int i = n-1; i >= 0; i--)
                suf[i] = s[i] == '|' ? i : suf[i+1];
            int [] ans = new int [queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = suf[queries[i][0]], r = pre[queries[i][1]+1]; // 注意： 右蜡烛边界 
                if (l < r)
                    ans[i] = r - l  - (sum[r] - sum[l]);
            }
            System.out.println("2*256*256: " + 2*256*256);
            return ans;
        }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "***|**|*****|**||**|*";
        // int [][] b = new int [][] {{1,17},{4,5},{14,17},{5,11},{15,16}};

        String a = "**|**|***|";
        int [][] b = new int [][] {{2,5},{5,9}};

        // // int [][] a = new int [][] {{1,3,2},{4,5,2},{2,4,3}};
        // int [][] a = new int [][] {{1,3,2},{4,5,2},{1,5,5}};

        int [] r = s.platesBetweenCandles(a, b);
        System.out.println(Arrays.toString(r));
    }
}