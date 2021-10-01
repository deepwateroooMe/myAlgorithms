// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class SeatManager {

    Queue<Integer> q;

    public SeatManager(int n) {
        q = new PriorityQueue(n, new Comparator<Integer>() {
                @Override public int compare(Integer a, Integer b) {
                    return a -b;
                }
            });
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
    }
    
    public int reserve() {
        int res = 0;
        if (!q.isEmpty())
            res = q.poll();
        return res;
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
    
    public static void main(String[] args) {
        SeatManager s = new SeatManager(5); // Initializes a SeatManager with 5 seats.
       int r = s.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
       System.out.println("r: " + r);
       
       int r1 =  s.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
       System.out.println("r1: " + r1);
       
        s.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        int r2 = s.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        System.out.println("r2: " + r2);
        
        int r3 = s.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        System.out.println("r3: " + r3);
        
        int r4 = s.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
        System.out.println("r4: " + r4);
        
        int r5 = s.reserve();    // The only available seat is seat 5, so return 5.
        System.out.println("r5: " + r5);
        
        s.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
