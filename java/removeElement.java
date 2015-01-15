import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeElement {
    public static class Solution {
        public int removeElement(int[] A, int elem) {
            if (A == null || A.length == 0) return 0;
            int i = 0;
            int j = 0;
            while (j < A.length) {
                while (j < A.length && A[j] == elem) j++;
                while (j < A.length && A[j] != elem) {
                    A[i] = A[j];
                    i++;
                    j++;
                }
            }
            if (i == 0 && A[j-1] == elem) return 0;
            return i;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1};
        int res = result.removeElement(a, 1);
        
        System.out.println(res);
    }
}
