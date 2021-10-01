import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findMissingRanges {
    private static List<String> result = new ArrayList<String>();// forgot to allocate space initially
    public static class Solution {
        public void addMissingRange(int left, int right) {
            StringBuffer tmp = new StringBuffer(); // allocate space first
            if (right < left) {
                return;
            } else if (right == left) {
                tmp.append(left);
            } else {
                tmp.append(left);
                tmp.append("->");
                tmp.append(right);
            }
            result.add(tmp.toString());
        }

        public List<String> findMissingRanges(int[] A, int lower, int upper) {
            int last = lower - 1;
            for(int i = 0; i < A.length; ++i) {
                addMissingRange(last+1, A[i]-1);
                last = A[i];
            }
            addMissingRange(last+1, upper);
            return result;
        }
    };
        
    public static void main(String[] args) {
       Solution result = new Solution();
       int n = 5;
       int a[] = {0, 1, 3, 50, 75};
       List<String> res = result.findMissingRanges(a, 0, 99);
       
       for(int i = 0; i < res.size(); ++i) {
           System.out.println(res.get(i));
       }
    }
}
