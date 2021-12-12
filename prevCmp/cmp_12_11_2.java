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

        public int countPoints(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] cnt = new int [10];
            Map<Character, Integer> m = new HashMap<>();
            m.put('R', 0);
            m.put('G', 1);
            m.put('B', 2);
            for (int i = 0; i < n-1; i += 2) {
                char c = s[i];
                int idx = s[i+1] - '0';
                cnt[idx] |= (1 << m.get(c));
            }
            int ans = 0;
            for (int i = 0; i < 10; i++) 
                if ((cnt[i] & 111) == 7)
                    ans++;
            return ans;
        }

        public long subArrayRanges(int[] a) {
            int n = a.length;
            // ArrayDeque<Integer> min = new ArrayDeque<>(); // increase
            // ArrayDeque<Integer> max = new ArrayDeque<>(); // decr
            Queue<Integer> min = new PriorityQueue<>((x, y)->x-y);
            Queue<Integer> max = new PriorityQueue<>((x, y)->y-x);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                min.clear();
                max.clear();
                min.offer(a[i]);
                max.offer(a[i]);
                // min.offerLast(a[i]);
                // max.offerLast(a[i]);
                for (int j = i+1; j < n; j++) {
                    // while (!min.isEmpty() && min.peekLast() >= a[i]) min.pollLast();
                    // while (!max.isEmpty() && max.peekLast() <= a[i]) max.pollLast();
                    min.offer(a[j]);
                    max.offer(a[j]);
                    // if (!min.isEmpty() && !max.isEmpty())
                        sum += max.peek() - min.peek();
                }
            }
            return sum;
        }

        public int minimumRefill(int[] p, int ca, int cb) { // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
            int n = p.length;
            if (n == 1) return 0;
            long v = ca, vb = cb;
            int ans = -1, i, j;
            int [] a = new int [n];
            int [] b = new int [n];
            for ( i = 0, j = n-1; i <= j; i++, j--) {
                if (i < j) {
                    if ((int)v >= p[i]) {
                        a[i] = (i == 0 ? 0 : a[i-1]);
                        v -= p[i];
                    } else {
                        a[i] = (i == 0 ? 0 : a[i-1]) + 1;
                        // v = v + ca - p[i]; // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
                        v = ca - p[i];
                    }
                    if (vb >= p[j]) {
                        b[j] = (j == n-1 ? 0 : b[j+1]);
                        vb -= p[j];
                    } else {
                        b[j] = (j == n-1 ? 0 : b[j+1]) + 1;
                        // vb = vb + cb - p[j]; // 这应该就是睡眠受干扰表现出来的症状吧：明明思路很对，在一个细节上硬死
                        vb = cb - p[j];
                    } 
                } else if (i == j) {
                    if (v >= vb) ans = (v >= p[i] ? a[i-1] + b[j+1] : a[i-1] + b[j+1] + 1);
                    else {
                        if (vb >= p[j]) ans = a[i-1] + b[j+1];
                        else ans = a[i-1] + b[j+1] + 1;
                    }
                } 
            }
            // System.out.println("ans: " + ans);
            // System.out.println("i: " + i);
            // System.out.println("j: " + j);
            if (ans == -1) ans = a[i-1] + b[j+1];
            // System.out.println(Arrays.toString(a));
            // System.out.println(Arrays.toString(b));
            return ans;
        }

        public int maxTotalFruits(int[][] a, int s, int k) { // bug: 自己写的，思路不通
            int n = a.length, sum = 0;
            if (n == 1) return Math.abs(a[0][0] - s) <= k ? a[0][1] : 0;
            for (int i = 0; i < n; i++) {
                int [] p = a[i];
                if (Math.abs(s - p[0]) <= k) {
                    adj.computeIfAbsent(s, z -> new ArrayList<>()).add(new int [] {p[0], p[1]});
                    if (s == p[0]) sum = p[1];
                }
                for (int j = i+1; j < n; j++) {
                    int [] c = a[j];
                    if (c[0] == s) continue;
                    if (c[0] - p[0] <= k) {
                        adj.computeIfAbsent(p[0], z -> new ArrayList<>()).add(new int [] {c[0], c[1]});;
                        adj.computeIfAbsent(c[0], z -> new ArrayList<>()).add(new int [] {p[0], p[1]});;
                    }
                }
            }
            // System.out.println("adj.size(): " + adj.size());
            // for (Map.Entry<Integer, List<int []>> en : adj.entrySet()) {
            //     System.out.print(en.getKey() + ": ");
            //     for (int [] zz : en.getValue()) 
            //         System.out.println(Arrays.toString(zz));
            // }
            vis = new boolean [a[n-1][0] + 1];
            if (adj.get(s) == null) return 0;
            for (int [] cur : adj.get(s)) {
                Arrays.fill(vis, false);
                vis[s] = true;
                // vis[cur[0]] = true;
                dfs(cur[0], s, sum + cur[1], k - (Math.abs(cur[0] - s)));
            }                
            // dfs(s, -1, sum);
            return max;
        }
        Map<Integer, List<int []>> adj = new HashMap<>();
        boolean [] vis;
        int max = 0;
        void dfs(int idx, int p, int cnt, int k) { // 为什么我就不能建个图，暴力地去搜呢？也会剪枝的呀。。。。。。
            if (k < 0) return ;
            vis[idx] = true;
            max = Math.max(max, cnt);
            if (adj.get(idx) == null || adj.get(idx).size() == 1 && adj.get(idx).get(0)[0] == p) 
                return ;
            if (k == 0) return ;
            for (int [] next : adj.get(idx)) {
                if (next[0] == idx) continue;
                // if (next[0] == idx || vis[next[0]]) continue;
                // vis[next[0]] = true;
                dfs(next[0], idx, cnt + next[1], k - Math.abs(next[0] - idx));
                // vis[next[0]] = false;
            }
        }
        // (r - start) * 2 + l is with sliding window is probably the better way, // 网络上的解法
        // but using TreeMap to get the position seems more intuitive to me:
        // Calculate result only going one way, record remain_k and value, then look at the opposite side,
        // use tree map and remain_k to get to the maximun point it can reach on the other side of startPos
        public int maxTotalFruits(int[][] a, int sp, int k) {
            TreeMap<Integer, int []> m = new TreeMap<>(); // <pos, int[]{remainK, Value}>
            m.put(sp, new int [] {k, 0});
            int ans = 0;
            int s = binarySearch(a, sp); // not really necessary, linear search would work
            int curK = k;
            int curV = 0;
            int curP = sp;
            for (int i = s; i < a.length; i++) { // 一直向右
                if (curK < Math.abs(a[i][0] - curP)) break; // 步长不够用了 
                curK -= Math.abs(a[i][0] - curP);
                curP = a[i][0];
                curV += a[i][1];
                m.put(curP, new int [] {curK, curV});
                ans = Math.max(ans, curV);
            }
            curK = k; // 一直向左走
            curV = 0;
            curP = sp;
            for (int i = s-1; i >= 0; i--) {
                if (curK < Math.abs(curP - a[i][0])) break;
                curK -= Math.abs(curP - a[i][0]);
                curP = a[i][0];
                curV += a[i][1];
                m.put(curP, new int [] {curK, curV});
                ans = Math.max(ans, curV);
            }
            Map.Entry<Integer, int []> canReach = null;
            for (Map.Entry<Integer, int []> en : m.entrySet()) {
                int key = en.getKey();
                int [] cur = en.getValue();
                if (key < sp) { // 先左走，再向右拐弯
                    canReach = m.floorEntry(key + cur[0]); // <= key + remainK
                    if (canReach == null || canReach.getKey() == key || canReach.getKey() <= sp) continue; // 没拐过去，还在左侧
                } else { // key >= sp 先右行，再拐变向左
                    canReach = m.ceilingEntry(key - cur[0]); // <= key - remainK
                    if (canReach == null || canReach.getKey() == key || canReach.getKey() >= sp) continue; // 没拐过去，还在右侧
                }
                ans = Math.max(ans, canReach.getValue()[1] + cur[1]);
            }
            return ans;
        }
        int binarySearch(int [][] a, int v) {
            int l = 0, r = a.length;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                // if (a[m][0] == v) return m; 
                if (a[m][0] > v) r = m;
                else l = m;
            }
            return a[l][0] >= v ? l : r;
        }
        public int maxTotalFruits(int[][] fruits, int startPos, int k) { // 这种编码代码风格，能把人看疯。。。。。。 todo: 改天再看这个吧
            int N = 200000 + 1;
            int[] a=new int[N];
            for(int [] f: fruits){ // put the fruits on number-line
                a[f[0]]=f[1];
            }
            if(k==0) // base case if k==0 return a[startPos]
                return a[startPos];
            int ans=0;
            int start = (startPos-k <0 ) ? 0: startPos-k; // Pick the start of fist window start = startPost-k and end = startPos
            int size=startPos-start+1;
            for(int l=start;l<=startPos;l++)
                ans+=a[l];
            // from now onwards i= start index of the window and  j= end index of the window
            int i= (startPos-start>=k)?start+1: start, j=startPos+1; 
            int sum=ans;
            // if my current window size is less than k, keep the initial sum intact otherwise subtract a[start] and move ahead
            sum-= i==start?0:a[start];
            while(i<=j && j< N)  {
                int left= startPos-i;
                int right= j-startPos;
                if( j>startPos+k) //make sure the end index of the window does not cross (startPos+k)
                    break;
                if(right>left){ // if current window has more elements on the right of startPos and lesser elements on the left of startPos. Then, every step to the left will contribute twice (because we have to come back to startPos to move towards right). 
                    int ls= left*2;
                    if(k>=ls+right){
                        sum+=a[j];
                    }else{
                        sum-=a[i];
                        i++;
                        j--;
                    }
                }else{
                    if(left>right){ // if current window has more elements on the left of startPos and lesser elements on the right of startPos. Then, every step to the right will contribute twice (because we have to come back to startPos to move towards left)
                        int rs= right*2;
                        if(k>= rs+left){
                            sum+=a[j];
                        }else{
                            sum-=a[i];
                            i++;
                            j--;
                        }
                    }else{ // number of steps are same on either side of startPos
                        int ls=2*left;
                        if(k>= ls+right){
                            sum+= a[j];
                        }else{
                            sum-=a[i];
                            i++;
                            j--;
                        }
                    }
                }
                ans=Math.max(ans, sum); // keep track of maximum sum we got
                j++;
            }
            return ans;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int [][] a = new int [][] {{2,8},{6,3},{8,6}};

        int r = s.maxTotalFruits(a, 5, 4);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// ListNode r = s.deleteMiddle(head);
// r.printList(r);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// String r = s.getDirections(root, 2, 1);
// System.out.println("r: " + r);
