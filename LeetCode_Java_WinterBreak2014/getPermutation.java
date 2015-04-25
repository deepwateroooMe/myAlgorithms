import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.LinkedList;

public class getPermutation {
    // idea is straight forward, but all kinds of wired xxx...
    public static class Solution {
        public long getp(long n) { // get product
            if (n == 0) return 1;
            if (n == 1) return 1;
            return n * getp(n - 1);
        }
        
        public void helper(long n, long k, List<Integer> dgt, StringBuilder res) {
            if (dgt.size() == 0) return;
            long bktsize = getp(dgt.size() - 1);
            long bkt = (k - 1) / bktsize + 1;
            long curr = dgt.remove((int)bkt - 1); // remove from list at (int)idx
                                                  // remove from list of (Object) type
            //System.out.println("curr: " + curr);
            //System.out.println("bkt - 1: " + (bkt - 1));
            res.append((char)(curr + '0'));
            //res.append((char)((int)(bkt - 1) + '0'));
            
            helper(n, k - (bkt - 1) * bktsize, dgt, res);
        }

        public String getPermutation(int n, int k) {
            StringBuilder res = new StringBuilder();
            List<Integer> dgt = new LinkedList<Integer>();
            for (int i = 1; i <= n ; i++) 
                dgt.add(i);
            k = (int)((long)(k - 1) % getp(n) + 1);
            helper(n, k, dgt, res);
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String res = result.getPermutation(3, 1);
        System.out.println(res);
    }
}
