// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MedianFinder {

    Queue<Integer> sma = new PriorityQueue<>((a, b) -> b-a);
    // PriorityQueue<Integer> sma = new PriorityQueue<Integer>(Collections.reverseOrder());
    Queue<Integer> lar = new PriorityQueue<>(); // (a, b) -> a-b by default
    public MedianFinder() {
        // sma = new PriorityQueue<>((a, b) -> b-a);
        // lar = new PriorityQueue<>((a, b) -> a-b);
    }
    // 建立两个 PriorityQueue 定义为smallHalf和largeHalf，分别代表较小的一半数字与较大的另一半数字。
    // 其中smallHalf设定为降序排列，largeHalf为升序排列，
    // 插入数据时，当 smallHalf 与 largeHalf 的元素个数相同时，我们向 smallHalf 插入当前数字，
    // 插入后，由于要保证 smallHalf 中的元素都小于等于 largeHalf 中的元素，所以我们需要将 smallHalf 中最大的一个元素移动到 largeHalf 中。
    // 当 smallHalf 与 largeHalf 的元素个数不同时，我们向 largeHalf 插入当前元素，同时还需要将 largeHalf 中最小的元素移动到 smallHalf 中。
    public void addNum(int num) {
        if (sma.size() == lar.size()) {
            sma.offer(num);
            lar.offer(sma.poll());
        } else {
            lar.offer(num);
            sma.offer(lar.poll());
        }
    }
    public double findMedian() {
        if (sma.size() == lar.size())
            return (sma.peek() + lar.peek()) / 2.0;
        else if (sma.size() > lar.size())
            return sma.peek();
        else
            return lar.peek();
    }
    
    public static void main(String[] args) {

        MedianFinder s = new MedianFinder();
        s.addNum(-1);
        s.addNum(-2);
       double r = s.findMedian();
        System.out.println("r: " + r);
        s.addNum(-3);

        double r2 = s.findMedian();
        System.out.println("r2: " + r2);
    }
}