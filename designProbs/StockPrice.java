// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class StockPrice {


    // List<Integer> tree;
    // public class MaxSeg {
    //     // List<Integer> tree = new ArrayList<>();
    //     int n;
    //     public MaxSeg (int [] arr) {
    //         n = arr.length;
    //         tree = new ArrayList<>(2 * n);
    //         for (int i = 0; i < n; i++)
    //             tree.add(0);
    //         for (int i = 0; i < n; i++)
    //             tree.add(arr[i]); // same effect as below
    //         for (int i = n-1; i >= 0; i--) // i >= 0
    //             tree.set(i, Math.max(tree.get(2 * i), tree.get(2 * i+1)));
    //     }
    //     public void update(int idx, int v) {
    //         idx += n;
    //         tree.set(idx, v);
    //         while (idx > 1) {
    //             idx /= 2;
    //             tree.set(idx, Math.max(tree.get(2 * idx), tree.get(2 * idx+1)));
    //         }
    //     }
    //     public int getMax(int l, int r) {
    //         l += n;
    //         r += n;
    //         int max = Integer.MIN _ VALUE;
    //         while (l < r) {
    //             if ((l & 1) == 1) {
    //                 max = Math.max(max, tree.get(l));
    //                 l++;
    //             }
    //             if ((r & 1) == 1) {
    //                 r--; // order matters !!!
    //                 max = Math.max(max, tree.get(r));
    //             }
    //             l >>= 1;
    //             r >>= 1;
    //         }
    //         return max;
    //     }
    //     public class MinSeg {
    //         // List<Integer> tree = new ArrayList<>();
    //         // int n;
    //         // public MinSeg (int [] arr) {
    //         //     n = arr.length;
    //         //     tree = new ArrayList<>(2*n);
    //         //     for (int i = 0; i < n; i++) 
    //         //         tree.add(0);
    //         //     for (int i = 0; i < n; i++) 
    //         //         tree.add(arr[i]); 
    //         //     for (int i = n-1; i >= 0; i--)  // i >= 0
    //         //         tree.set(i,  Math.min(tree.get(2*i),  tree.get(2*i+1)));
    //         // }
    //         public void update(int idx,  int v) {
    //             idx += n;
    //             tree.set(idx,  v);
    //             while (idx > 1) {
    //                 idx /= 2;
    //                 tree.set(idx,  Math.min(tree.get(2*idx),  tree.get(2*idx+1)));
    //             }
    //         }
    //         public int getMin(int l,  int r) { // [l, r) include left, not included right
    //             l += n;
    //             r += n;
    //             int min = Integer.MAX_VALUE;
    //             while (l < r) {
    //                 if ((l & 1) == 1) {
    //                     min = Math.min(min,  tree.get(l));
    //                     l++;
    //                 }
    //                 if ((r & 1) == 1) {
    //                     r--; // order matters !!!
    //                     min = Math.min(min,  tree.get(r));
    //                 }
    //                 l >>= 1;
    //                 r >>= 1;
    //             }
    //             return min;
    //         }
    //     }

    // }
    class Pt {
        int t;
        int v;
        public Pt (int a, int b) {
            t = a;
            v = b;
        }
    }
    Map<Integer, Integer> m;
    Queue<Pt> maxq;
    Queue<Pt> minq;
    int lastT;
    public StockPrice() {
        m = new HashMap<Integer, Integer>();
        maxq = new PriorityQueue<>((a, b)-> b.v - a.v);
        minq = new PriorityQueue<>((a, b)-> a.v - b.v);
        lastT = -1;
    }
    
    public void update(int timestamp, int price) {
        m.put(timestamp, price);
        maxq.offer(new Pt(timestamp, price));
        minq.offer(new Pt(timestamp, price));
        if (lastT == -1 || timestamp > lastT) lastT = timestamp;
    }
    
    public int current() {
        return m.get(lastT);
    }
    
    public int maximum() {
        while (!maxq.isEmpty() && maxq.peek().v != m.get(maxq.peek().t)) maxq.poll();
        return maxq.peek().v;
    }
    
    public int minimum() {
        while (!minq.isEmpty() && minq.peek().v != m.get(minq.peek().t)) minq.poll();
        return minq.peek().v;
    }
    
    public static void main(String[] args) {
        StockPrice s = new StockPrice();
        
        
    }
}
