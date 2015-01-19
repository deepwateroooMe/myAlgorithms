import com.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class cloneGraph {
    public static class Solution {
        // somewhere I think I am still confused
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;
            Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
            UndirectedGraphNode res = new UndirectedGraphNode(node.val);
            if (node.neighbors == null || node.neighbors.size() == 0) return res;
            
            map.put(res.val, res);
            int bgnKey = node.val;
            int val;
            UndirectedGraphNode tmp = null;

            // root node done
            for (int i = 0; i < node.neighbors.size(); i++) {
                val = node.neighbors.get(i).val;
                if (!map.containsKey(val)) {
                    tmp = new UndirectedGraphNode(val);
                    map.put(val, tmp);                    
                    res.neighbors.add(tmp);
                } else
                    res.neighbors.add(map.get(val));
            }
            
            for (Integer key : map.keySet()) {
                if (key != bgnKey) {
                    node = map.get(key); // one neight node
                    for (int i = 0; i < node.neighbors.size(); i++) {
                        val = node.neighbors.get(i).val;
                        if (!map.containsKey(val)) {
                            tmp = new UndirectedGraphNode(val);
                            map.put(val, tmp);                    
                            res.neighbors.add(tmp);
                        } else
                            res.neighbors.add(map.get(val));
                    }
                    
                }
            }

        }

            

        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 1, 2 -1, 1, 2 -1, 2, 2};
        UndirectedGraphNode node = new UndirectedGraphNode(a[0]);
        node.buildUndirectedGraph(node, a);
        node.
        

        System.out.println(res);
    }
}
