// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class mfiveixed {
    public static class Solution {

//         public long countSubarrays(int[] a, int min, int max) {
//             int n = a.length, minIdx = -1, maxIdx = -1, last = -1;
//             long r = 0;
//             for (int i = 0; i < n; i++) { 
//                 int v = a[i];
//                 if (v == min) minIdx = i;
//                 if (v == max) maxIdx = i; // 当不是 else-if 时，就可以同时 min-max
//                 if (v < min || v > max)
//                     last = i; // 记录【 min,max】合法范围之外，任意不合法数字在区间前，最后一次出现的下标
// // 当Math.min(minIdx, maxIdx) - last 《 0 时为 last 不合法数字的右侧， min-max 没能两个都出现，不合法
//                 r += Math.max(Math.min(minIdx, maxIdx) - last, 0); 
//             }
//             return r;
//         }

        // public long makeSimilar(int[] a, int[] b) {
        //     int n = a.length;
        //     preProcessArray(a);
        //     preProcessArray(b);
        //     var r = 0l;
        //     for (int i = 0; i < a.length; i++)
        //         ans += Math.abs(a[i] - b[i]);
        //     return r / 4l;
        // }
        // void preProcessArray(int [] a) {
        //     // 由于元素都是正数，把奇数变成相反数，这样排序后奇偶就自动分开了
        //     for (int i = 0; i < a.length; i++)
        //         if (a[i] % 2 == 1) a[i] = -a[i];
        //     Arrays.sort(a);
        // }

        // public int latestTimeCatchTheBus(int[] bus, int[] pas, int cap) { // 写是写出来了，但是条理性差了很多
        //     Arrays.sort(bus);
        //     Arrays.sort(pas);
        //     Set<Integer> sp = new HashSet<>(Arrays.stream(pas).boxed().collect(Collectors.toList()));
        //     int m = bus.length, n = pas.length;
        //     int i = 0, j = 0, r = 0, ans = -1; // 两个下标，乘客数
        //     while (i < m && j < n) {
        //         while (j < n && i < m && pas[j] <= bus[i]) {
        //             r++;
        //             j++;
        //         }
        //         if (r >= cap) {
        //             r -= cap;
        //             ans = Math.max(ans, pas[j - r -1] -1);
        //         } else if (r < cap && i < m) { // r < cap
        //             ans = Math.max(ans, bus[i]); // 找到一个最晚乘坐的车时，最晚发车时间
        //             r = 0;
        //         }
        //         i++;
        //     }
        //     if (i < m) return bus[m-1]; // 最后一班还有空位
        //     while (sp.contains(ans)) --ans;
        //     return ans;
        // }
//         public int latestTimeCatchTheBus(int[] bus, int[] pas, int cap) {
//             Arrays.sort(bus);
//             Arrays.sort(pas);
//             int j = 0, c = 0;
//             for (int t : bus) // 这里选择：把车遍历完 
//                 for (c = cap; c > 0 && j < pas.length && pas[j] <= t; c--) 
//                     ++j;
//             --j;
// // 【最后一般车有空位 c>0】在发车时到达公交站； or 【车全坐满】上一个上车的乘客【必须赶在最后一个坐上车的乘客的前面】
//             var ans = c > 0 ? bus[bus.length - 1] : pas[j]; 
//             while (j >= 0 && pas[j--] == ans) --ans;
//             return ans;
//         }

        
    } 
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        // int [] a = new int [] {3};
        // int [] b = new int [] {2, 4};
        int [] a = new int [] {6,8,18,17};
        int [] b = new int [] {6,8,17};

        int r = s.latestTimeCatchTheBus(a, b, 1);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
