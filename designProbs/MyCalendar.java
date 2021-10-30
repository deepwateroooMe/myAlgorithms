// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javafx.util.Pair;
import static java.util.stream.Collectors.toMap;

public class MyCalendar {

    // private TreeSet<Pair<Integer, Integer>> lap;
    // private TreeSet<Pair<Integer, Integer>> indi;
    // public MyCalendarTwo() {
    //     lap = new TreeSet<>((a, b) -> a.getKey() - b.getKey());
    //     indi = new TreeSet<>((a, b) -> a.getKey() - b.getKey());
    // }
    // public boolean book(int start, int end) {
    //     if (lap.size() > 0) {
    //         for (Pair<Integer, Integer> val : lap) {
    //             if (start >= val.getValue() || end <= val.getKey()) continue;
    //             return false;
    //         }
    //     }
    //     if (indi.size() > 0) {
    //         for (Pair<Integer, Integer> val : indi) {
    //             if (start >= val.getValue() || end <= val.getKey()) continue;
    //             lap.add(new Pair<>(Math.max(start, val.getKey()), Math.min(end, val.getValue())));
    //         }
    //     }
    //     indi.add(new Pair<>(start, end));
    //     return true;
    // }
    
    // public MyCalendar() {
    //     map = new TreeMap<>();
    // }
    // public boolean book(int start, int end) {
    //     Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
    //     if (floorEntry != null && floorEntry.getValue() > start) // if floor.end > start 已订之前事件中最接近当前事件的node
    //         return false;
    //     Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
    //     if (ceilingEntry != null && ceilingEntry.getKey() < end) // if ceiling.start < end 后续事件早于想要订阅的结束时间点
    //         return false;
    //     map.put(start, end);
    //     return true;
    // }

    
    // private TreeMap<Integer, Integer> map;
    // public MyCalendar() {
    // // public MyCalendarThree() {
    //     map = new TreeMap<Integer, Integer>();
    // }
    // // interval相关的题目，一直都没有太好的总结， 解题做法通常有二分搜索，sweepline（扫描线算法），线段树（segment tree)等， 然后也比较灵活，边界条件又特别容易出错。
    // // 这个题目还有线段树的做法，这个以后再学。
    // // 扫描线算法，对于任意一个时间点， 如果是start，就把计数为1（相当于进入了一个区间）， 如果是end, 就计数为-1（相当于离开了一个区间）
    // //     那么， 如果对于所有的时间点排序， 那么从左到右把这些数都计算一下，取最大值，就是要返回的值
    // public int book(int start, int end) {
    //     map.put(start, map.getOrDefault(start, 0) + 1);
    //     map.put(end, map.getOrDefault(end, 0) - 1);
    //     int max = 0, k = 0;
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         k += entry.getValue();
    //         max = Math.max(max, k);
    //     }
    //     // System.out.println("map.size(): " + map.size());
    //     // for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
    //     //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
    //     return max;
    // }

    // 线段树放在这道题上其实非常显然， 只需要简单的调用几次线段树的方法就可以得到结果。大致如下：

    // 每次插入一条线段， 对应更新线段树中原先线段上的值。这里，线段的值就是该线段出现的次数。
    // 用一个变量记录最大值。每次在插入线段时维护这个最大值。 插入完之后最大值即为当次结果返回
    // 以上就是线段树的做法。这个做法的缺点如下：
    // 1. 线段树写起来繁琐。 这个写过的自然懂。
    // 2. 线段树的范围太大。 注意到这道题的数据范围对朴素线段树是十分不友好的： 插入次数 < 400, 而插入范围是109 直接储存直接爆内存应该毫无疑问。 显然要做压缩。
    // 3. 由于是动态查询， 我们不能事先知道线段的起始与终点， 因此压缩比较麻烦。。。
    //     好吧下面开始正题。
    //     这个题目其实也并没用到线段树的很多功能。所以尝试用直接记录起点终点来代表一个线段。
    //     这样需要解决一点问题， 比如：
    //     1. 若用一个数组来记录经过某个点的线段数目， 那么无法分清经过从该点的出发的还是只是经过的。
    //     2. 若用两个数组来分别记录出发和经过，很难更新它们的值： 考虑到某个点既可能出发， 也可能是终止，还可能只是经过。。。当一个新的状态要被更新时， 我们无法从之前保存的状态完全恢复之前所有的信息。
    //     换一种想法： 如果只是保存起始和终点的情况，而完全不管中间经过的点呢？
    //     类似于图， 线段可以看做是一条有向边， 每次从一个点A指向B,相当于A的出度+1， B的入度 + 1。
    //     这种情况下， 找到整个数轴上出度最大的点就是被覆盖次数最多的点。
    
    public static void main(String[] args) {
        MyCalendar s = new MyCalendar();
        int r = s.book(10, 20);
        System.out.println("r: " + r);
        
        int r1 = s.book(50, 60);
        System.out.println("r1: " + r1);
        
        int r2 = s.book(10, 40); // t
        System.out.println("r2: " + r2);
        
        int r3 = s.book(5, 15);
        System.out.println("r3: " + r3);
        
        int r4 = s.book(5, 10);
        System.out.println("r4: " + r4);
        
        int r5 = s.book(25, 55);
        System.out.println("r5: " + r5);
        
    //     [null,true,true,false,true,false,true]
    // Expected:
    //     [null,true,true,true,false,true,true]

    }
}