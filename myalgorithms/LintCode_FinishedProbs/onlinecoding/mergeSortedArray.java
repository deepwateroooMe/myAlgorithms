import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class mergeSortedArray {
    public static class Solution {
        /**
         * @param A and B: sorted integer array A and B.
         * @return: A new sorted integer array
         */
        public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
            int m = A.size();
            int n = B.size();
            ArrayList<Integer> res = new ArrayList<Integer>();
            int i = 0, j = 0;
            while (i < m || j < n) {
                while (i < m && j < n) {
                    if (A.get(i) <= B.get(j)) 
                        res.add(A.get(i++));
                    else res.add(B.get(j++));
                }
                if (i == m && j == n) return res;
                if (i == m) while (j < n) res.add(B.get(j++));
                else while (i < m) res.add(A.get(i++));
                return res;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        Integer [] a = {1, 2, 3, 4};
        Integer [] b = {2, 4, 5, 6};
        ArrayList<Integer> res = result.mergeSortedArray(new ArrayList<Integer>(Arrays.asList(a)),
                                                         new ArrayList<Integer>(Arrays.asList(b)));

        System.out.println(res);
    }
}
