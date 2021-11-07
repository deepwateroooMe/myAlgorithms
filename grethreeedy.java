import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class grethreeedy {
    public static class Solution {
            
        // public int findMinMoves(int[] machines) {
        //     int n = machines.length, sum = Arrays.stream(machines).sum(), avg = sum / n;
        //     if (sum % n != 0) return -1;
        //     int ans = 0;
        //     for (Integer v : machines) 
        //         ans += Math.abs(avg - v);
        //     return ans / 2;
        // }

        public int minTimeToType(String word) {
            int n = word.length(), ans = 0, pre = 0;
            char [] s = word.toCharArray();
            for (int i = 0; i < n; i++) {
                int idx = s[i] - 'a';
                int dis = Math.min(Math.abs(idx-pre), 26 - idx +pre);
                System.out.println("dis: " + dis);
                ans += dis;
                System.out.println("ans: " + ans);
            }
            return ans;
        }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "bza";

        int r = s.minTimeToType(a);
        System.out.println("r: " + r);
    }
}