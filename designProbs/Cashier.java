// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class Cashier {

    int idx, discnt, m, n;
    Map<Integer, Integer> prices = new HashMap<>();
    public Cashier(int n, int discount, int[] products, int[] prices) {
        idx = 0;
        m = products.length;
        discnt = discount;
        this.n = n;
        for (int i = 0; i < m; i++) 
            this.prices.put(products[i], prices[i]);
    }
    public double getBill(int[] product, int[] amount) {
        double ans = 0;
        for (int i = 0; i < product.length; i++) {
            idx += 1;
            if (idx % n == 0) 
                ans += (double)prices.get(product[i]) * amount[i] * (100 - discnt) / 100;
            else ans += (double)prices.get(product[i]) * amount[i];
            System.out.println("ans: " + ans);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int [] a = new int [] {1, 2, 3, 4, 5, 6, 7};
        int [] b = new int [] {100,200,300,400,300,200,100};

        Cashier s = new Cashier(3,50, a, b);

        int [] c = new int [] {1, 2};
        int [] d = new int [] {1, 2};
        double r = s.getBill(c, d);                        // return 500.0. 1st customer, no discount.
        System.out.println("r: " + r);
        
        // // bill = 1 * 100 + 2 * 200 = 500.
        // double r1 = s.getBill([3,7],[10,10]);                      // return 4000.0. 2nd customer, no discount.
        // System.out.println("r1: " + r1);
        
        // // bill = 10 * 300 + 10 * 100 = 4000.
        // double r2 =         s.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // return 800.0. 3rd customer, 50% discount.
        // System.out.println("r2: " + r2);
        
        // // Original bill = 1600
        // // Actual bill = 1600 * ((100 - 50) / 100) = 800.
        // double r3 =         s.getBill([4],[10]);                           // return 4000.0. 4th customer, no discount.
        // System.out.println("r3: " + r3);
        
        // double r4 =         s.getBill([7,3],[10,10]);                      // return 4000.0. 5th customer, no discount.
        // System.out.println("r4: " + r4);
        
        // double r5 =         s.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // return 7350.0. 6th customer, 50% discount.
        // System.out.println("r5: " + r5);
        
        // // Original bill = 14700, but with
        // // Actual bill = 14700 * ((100 - 50) / 100) = 7350.
        // double r6 = s.getBill([2,3,5],[5,3,2]);                    // return 2500.0.  6th customer, no discount.
        // System.out.println("r6: " + r6);
    }
}
