import com.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class cloneGraph {
    public static class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;
            UndirectedGraphNode res = new UndirectedGraphNode(node.label);  // result head
            if (node.neighbors == null || node.neighbors.size() == 0) return res;

            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            q.add(node);         // added first node, need add its all Neighbors as well
            map.put(node, res);

            List<UndirectedGraphNode> curNbr = new ArrayList<UndirectedGraphNode>();
            UndirectedGraphNode curr = null;
            while (!q.isEmpty()) {
                curr = q.poll();
                curNbr = curr.neighbors;   // ori
                for (UndirectedGraphNode aNbr : curNbr) {    // for build connection among copies
                    if (!map.containsKey(aNbr)) {
                        UndirectedGraphNode acpNbr = new UndirectedGraphNode(aNbr.label);
                        map.put(aNbr, acpNbr);
                        map.get(curr).neighbors.add(acpNbr);
                        q.add(aNbr);
                    } else
                        map.get(curr).neighbors.add(map.get(aNbr));                        
                    //q.add(aNbr);
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 1, 2 -1, 1, 2 -1, 2, 2};
        UndirectedGraphNode node = new UndirectedGraphNode(a[0]);
        node.buildUndirectedGraph(node, a);
        /*
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
        */
    }
}

/*
Time Limit ExceededMore Details 
Last executed input: {0,0,0}
*/
