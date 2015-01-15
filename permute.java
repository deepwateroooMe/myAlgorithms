import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class permute {
    public static class Solution {

        public void removeElt( int [] arr, int remIndex ) {
            int numElts = arr.length - ( remIndex + 1 ) ;
            System.arraycopy( arr, remIndex + 1, arr, remIndex, numElts ) ;
        }

        // http://blog.csdn.net/tuantuanls/article/details/8717262
        public List<List<Integer>> permute(int[] num) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            if (num.length == 1) {
                list.add(new ArrayList<Integer>(Arrays.asList(1)));
                return list;
            }

            List<List<Integer>> post = new ArrayList<List<Integer>>();
            List<Integer> curr = new ArrayList<Integer>();
            int [] temp;
            List<Integer> tmp = new ArrayList<Integer>();

            for (int i = 0; i < num.length; i++) {
                for(int x : num)
                    if (x != num[i])
                        curr.add(x);
                curr = Arrays.asList(num);
                post = permute(temp);
                for (int j = 0; j < post.size(); j++) {
                    tmp = post.get(j);
                    tmp.add(0, num[i]);
                    list.add(tmp);
                }
            }
            return list;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        List<List<Integer>> res = result.permute(a);
        
        System.out.println(res);
    }
}
