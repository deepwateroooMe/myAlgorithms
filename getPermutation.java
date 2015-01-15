import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class getPermutation {
    public static class Solution {
        public StringBuilder perm(List<Integer> list, int k) {
            StringBuilder res = new StringBuilder();
            if (list.size() == 1) {
                //res = new StringBuilder(list.get(0)); // produce trouble
                res.append(list.get(0));
                return res;
            }
            if (k == 0) {
                for (int i = 0; i < list.size(); i++) 
                    res.append(list.get(i));
                return res;
            }

            int fact = 1;
            for (int i = 1; i < list.size() ; i++) 
                fact *= i;
            //System.out.println("fact: " + fact);
            res.append(list.get(k / fact));
            list.remove( k / fact);

            //System.out.println("list.size(): " + list.size());
            //System.out.println(list);
            //System.out.println("k: " + k);
            //System.out.println("res 0: " + res);
            
            if (k / fact != 0 && k % fact == 0)
                res.append(perm(list, (k - 1) % fact));
            else
                res.append(perm(list, k % fact));
            
            return res;
        }

        public String getPermutation(int n, int k) {
            StringBuilder res = new StringBuilder();
            int fact = 1;
            for (int i = 1; i < n ; i++) 
                fact *= i;
            if (k % fact == 0)
                res.append((k - 1) / fact + 1);
            else
                res.append(k / fact + 1);
            
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) 
                list.add(i);

            if (k % fact == 0)
                list.remove((k-1)/fact);
            else
                list.remove(k / fact);

            System.out.println(list);

            if (k % fact == 0)
                res.append(perm(list, (k - 1) % fact));                
            else
                res.append(perm(list, k % fact));

            
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String res = result.getPermutation(3, 1);
        System.out.println(res);
    }
}
