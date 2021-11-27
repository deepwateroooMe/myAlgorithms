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
        
        public boolean checkAlmostEquivalent(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [] one = new int [26];
            int [] two = new int [26];
            for (int i = 0; i < m; i++) 
                one[s[i]-'a']++;
            for (int i = 0; i < n; i++) 
                two[t[i]-'a']++;
            for (int i = 0; i < 26; i++) 
                if (Math.abs(one[i] - two[i]) > 3) return false;
            return true;
        }

        public int[] maximumBeauty(int[][] it, int[] que) {
            int n = it.length, m = que.length;
            List<int []> l = new ArrayList<>();
            for (int i = 0; i < m; i++) 
                l.add(new int [] {i, que[i]});
            Collections.sort(l, (a, b)->a[1] - b[1]);
            Arrays.sort(it, (a, b) -> a[0] - b[0]);
            Queue<int []> q = new PriorityQueue<>((a, b)->b[1] - a[1]);
            int [] ans = new int [m];
            int idx = 0;
            for (int i = 0; i < m; i++) { // l
                int p = l.get(i)[1];
                while (idx < n && it[idx][0] <= p) {
                    q.offer(it[idx]);
                    idx++;
                }
                if (!q.isEmpty()) ans[l.get(i)[0]] = q.peek()[1];
            }
            return ans;
        }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int x, y;
    private int n, m;
    private int dir, mod;
    private boolean firstMove;
    public Robot(int width, int height) {
        this.n = width;
        this.m = height;
        x = 0;
        y = 0;
        this.dir = 0;
        this.mod = n*2 + m*2 - 4;
        this.firstMove = true; // this indicates if the robots has started moving.
    }
    public void move(int num) {
        if (num / mod > 0 && num % mod == 0)
            // if and only if the robot moves for the first time and it ends at (0, 0)
            if (x == 0 && y == 0 && firstMove){
                firstMove = false;
                dir = 3;
            }
        num = num % mod;
        while (num > 0) {
            int [] d = dirs[dir];
            int steps = 0;
            if (dir == 0)
                steps = Math.min(n - x - 1, num);
            else if (dir == 1)
                steps = Math.min(m - 1 - y, num);
            else if (dir == 2)
                steps = Math.min(x, num);
            else steps = Math.min(y, num);
            x += steps * d[0];
            y += steps * d[1];
            num -= steps;
            if (steps == 0 || num > 0)
                dir = (dir + 1) % 4;
        }
    }
    public int[] getPos() {
        return new int[] {x, y};
    }
    public String getDir() {
        if (dir == 0) return "East";
        else if (dir == 1) return "North";
        else if (dir == 2) return "West";
        else return "South";
    }
    
    int [][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // tle bug
    int m, n, x, y, idx;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> pos = new HashMap<>();
    int [][] a;
    // public Robot(int width, int height) {
    public cmp(int width, int height) {
        this.m = height;
        this.n = width;
        a = new int [m][n];
        this.x = m-1;
        this.y = 0;
        this.idx = 0;
        // this.g = 0;
        for (int j = 0; j < n-1; j++) 
            map.put((m-1)*n+j, 0);
        for (int i = m-1; i > 0; i--) 
            map.put(i*n+n-1, 1);
        for (int j = n-1; j > 0; j--)
            map.put(j, 2);
        for (int i = 0; i < m-1; i++)
            map.put(i*n, 3);
        for (int i = 0; i < 2 * (m+n-2); i++)
            if (i < n-1) pos.put(i, (m-1)*n + i);
            else if (i < n + m - 2)
                pos.put(i, (m-1-(i-(n-1)))*n + n-1);
            else if (i < 2 * n + m - 3)
                pos.put(i, n-1-(i-(n+m-2)));
            else pos.put(i, (i-(2*n+m-3)*n));
    }
    public void move(int num) {
        num = (idx + num) % (2 * n + 2 * m - 4);
       idx = pos.get(num);
    }
    public int[] getPos() {
        int v = map.get(idx);
        int x = v / n, y = v % n;
        return new int [] {y, m-1 - x};
    }
    public String getDir() {
        int g = pos.get(x * n + y);
        return g == 0 ? "East" : (g == 1 ? "North" : (g == 2 ? "West" : "South"));
    }

        public int maxTaskAssign(int[] t, int[] w, int p, int s) {
            n = t.length;
            m = w.length;
            int ans = -1;
            Arrays.sort(t);
            Arrays.sort(w);
            // System.out.println(Arrays.toString(t));
            // System.out.println(Arrays.toString(w));

            int l = 0, r = n-1;
            while (l <= r) {
                int mid = l + (r-l) / 2;
                if (check(t, w, p, s, mid)) {
                    ans = mid;
                    l = mid + 1;
                } else r = mid - 1;
            }
            return ans + 1;
        }
        int m, n;
        private boolean check(int [] a, int [] b, int cnt, int val, int mid) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int j = m-1;
            for (int i = mid; i >= 0; i--) {
                // System.out.println("\n i: " + i);
                
                while (j >= 0 && b[j] >= a[i]) {
                    // System.out.println("j: " + j);
                    
                    map.put(b[j], map.getOrDefault(b[j], 0) + 1);
                    j--;
                    // System.out.println("map.size(): " + map.size());
                    // for (Map.Entry<Integer, Integer> en : map.entrySet()) 
                    //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
                }
                // System.out.println("map.size(): " + map.size());
                // for (Map.Entry<Integer, Integer> en : map.entrySet()) 
                //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
                
                Integer ceil = map.ceilingKey(a[i]);
                if (ceil != null) {
                    decreaseKey(map, ceil);
                } else {
                    if (cnt > 0) {
                        while (j >= 0 && b[j] + val >= a[i]) {
                            map.put(b[j], map.getOrDefault(b[j], 0) + 1);
                            j--;
                        }
                        ceil = map.ceilingKey(a[i] - val);
                        if (ceil != null) {
                            cnt--;
                            decreaseKey(map, ceil);
                        } else return false;
                    } else return false;
                }
            }
            return true;
        }
        private void decreaseKey(TreeMap<Integer, Integer> m, int k) {
            m.put(k, m.get(k) - 1);
            if (m.get(k) == 0) m.remove(k);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {5, 9, 8, 5, 9};
        int []  b = new int []  {1, 6, 4, 2, 6};

        int  r = s.maxTaskAssign(a, b, 1, 5);
        System.out.println("r: " + r);
       
        // cmp s = new cmp(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
        // s.move(2);  // It moves two steps East to (2, 0), and faces East.
        // s.move(2);  // It moves two steps East to (4, 0), and faces East.
        // int [] r =        s.getPos(); // return [4, 0]
        // System.out.println(Arrays.toString(r));

        // String str =   s.getDir(); // return "East"
        // System.out.println("str: " + str);
     
        // s.move(2);  // It moves one step East to (5, 0), and faces East.
        // // Moving the next step East would be out of bounds, so it turns and faces North.
        // // Then, it moves one step North to (5, 1), and faces North.
        // s.move(1);  // It moves one step North to (5, 2), and faces North (not West).
        // s.move(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
        // // Then, it moves four steps West to (1, 2), and faces West.
        // int [] b =  s.getPos(); // return [1, 2]
        // System.out.println(Arrays.toString(b));
      
        // s.getDir(); // return "West"
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
