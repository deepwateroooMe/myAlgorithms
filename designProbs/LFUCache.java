// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class LFUCache {

    // private class Node implements Comparable<Node> {
    private class Node {
        int key;
        int val;
        int fre = 1;
        int idx;

        public Node() {
        }
        public Node(int key, int val, int idx) {
            this.key = key;
            this.val = val;
            this.idx = idx;
        }
        // @Override public int CompareTo(Node tmp) {
        //     int res = this.fre - tmp.fre;
        //     return res == 0 ? this.idx - tmp.idx : res;
        // }
    }

    Map<Integer, Node> cache;
    Queue<Node> que;
    int capacity;
    int size;
    int index = 0;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        if (this.capacity > 0) {
            que = new PriorityQueue<>(this.capacity, new Comparator<Node>(){
                    public int compare(Node x, Node y) {
                        int res = x.fre - y.fre;
                        return res == 0 ? x.idx - y.idx : res;
                    }
                });
        }
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1; // node不存在，则返回 -1
        //每访问一次，频次和全局index都自增 1
        node.fre++;
        node.idx = this.index++;
        // 每次都重新remove，再offer是为了让优先队列能够对当前Node重排序
        //不然的话，比较的 freq 和 index 就是不准确的
        que.remove(node);
        que.offer(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            node.fre++;
            node.idx = this.index++;
            que.remove(node);
            que.offer(node);
        } else {
            if (size == capacity) {
                cache.remove(que.poll().key);
                size--;
            }
            node = new Node(key, value, index++);
            que.offer(node);
            cache.put(key, node);
            size++;
        }
    }
    
    // public static void main(String[] args) {
    //     int [] a = new int [] {};
    //     KthLargest s = new KthLargest(1, a);

    //     int res = s.add(-3);
    //     System.out.println("res: " + res);

    //     int r = s.add(-2);   // return 5
    //     System.out.println("r: " + r);
        
    //     int r1 = s.add(-4);  // return 5
    //     System.out.println("r1: " + r1);
        
    //     int r2 = s.add(0);   // return 8
    //     System.out.println("r2: " + r2);
        
    //     int r3 = s.add(4);   // return 8
    //     System.out.println("r3: " + r3);

        // ["KthLargest","add","add","add","add","add"]
        //     [[1,[]],[-3],[-2],[-4],[0],[4]]

    // }
}