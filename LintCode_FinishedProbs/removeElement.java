import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeElement {
    public static class Solution {
        public int removeElement(int[] a, int elem) {            
            int n = a.length;
            int i = -1;
            for (int j = 0; j < n; j++) {
                if (a[j] == elem) continue;
                a[++i] = a[j];
            }
            return i + 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 4, 4, 0, 0, 2, 4, 4};
        int res = result.removeElement(a, 4);
        System.out.println("res: " + res);
    }
}
