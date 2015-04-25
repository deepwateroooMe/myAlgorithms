import com.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class cloneGraph {
    public static class Solution {
        /**
         * @param node: A undirected graph node
         * @return: A undirected graph node
         */
        /**
         * Definition for undirected graph.
         * class UndirectedGraphNode {
         *     int label;
         *     ArrayList<UndirectedGraphNode> neighbors;
         *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         * };
         */
        //  feel like nuts... I guess I will hav to write com.UndirectedGraphNode just like TreeNode....
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            UndirectedGraphNode head = new UndirectedGraphNode(node.label);
            m.put(node, head);
            UndirectedGraphNode curr = null;
            for (int i = 0; i < node.neighbors.size(); i++) {
                curr = node.neighbors.get(i);
                if (m.containsKey(curr)) continue;
                else {
                    UndirectedGraphNode cpCurr = new UndirectedGraphNode(curr.label);
                    m.put(curr, cpCurr);
                    //head.neighbors.add(cpCurr);
                }
                head.neighbors.add(m.get(curr));
                q.add(curr);
            }
            UndirectedGraphNode newCurr = null;
            while (!q.isEmpty()) {
                curr = q.poll();
                for (int i = 0; i < curr.neighbors.size(); i++) {
                    if (m.containsKey(curr))
                        newCurr = m.get(curr);
                    else {
                        newCurr = new UndirectedGraphNode(curr.label);
                        m.put(curr, newCurr);
                    }
                    newCurr.neighbors.add(m.get(curr.neighbors.get(i)));
                }
            }
            return head;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        UndirectedGraphNode res = ;
        
        System.out.println(res);
    }
}
