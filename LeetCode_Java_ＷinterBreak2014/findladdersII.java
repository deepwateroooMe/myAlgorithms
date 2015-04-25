import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Arrays;

public class findladdersII {
    // understand clone undirected graph before this
    // unerstand most details now except slightly confusing about the len variable controlling end of searching,
    // it's slightly different controlling than my ladderlength.java method

    // don't really know which one I referred to now: understands the ideas
    // https://oj.leetcode.com/discuss/9523/share-two-similar-java-solution-that-accpted-by-oj
    
    public static class Solution {
        /* Graph of example:
         *                |--- dot --- dog ---|
         * hit --- hot -- |     |       |     |--- cog
         *                |--- lot --- log ---|
         * 
         */
        // set: visited   // current level used already
        // set: unvisited // leftover for choosing for next level to avoid repeat, initialize from dict + end
        // List<List<String>> res; // result paths
        // List<String, Queue<String>> adjMap; // adjacent directed graph, List<string, List<String>> works 2 ~! clone graph
        
        private List<String> getNextLadder(String currLadder, Set<String> unVisited){
            ArrayList<String> nextLadders = new ArrayList<String>();
            StringBuffer replace = new StringBuffer(currLadder); // mutate from here
            for(int i = 0; i < currLadder.length(); i++){
                char old = replace.charAt(i);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if (currLadder.charAt(i) != ch) 
                        replace.setCharAt(i, ch);
                    else continue;
                    String replaced = replace.toString();
                    if (unVisited.contains(replaced)) {
                        nextLadders.add(replaced);
                    }
                }
                replace.setCharAt(i, old); 
            }
            return nextLadders;
        }

        private void getLadders(String start, String end, LinkedList<String> path, List<List<String>> res,
                                HashMap<String, Queue<String>> adjMap){
                                //HashMap<String, Queue<String>> adjMap, int len){  // don't think len is necessary here
            if (end.equals(start)) {  // end condition, len ?
                res.add(new ArrayList<String> (path));   
            } else { //if (len > 0) {            
                Queue<String> adjs = adjMap.get(end);
                for (String lad : adjs) {
                    path.addFirst(lad); // path.add(0, lad); // equivallent
                    //getLadders(start, lad, path, res, adjMap, len - 1);
                    getLadders(start, lad, path, res, adjMap);
                    path.removeFirst(); // path.remove(0); // remove ele at idx 0
                }
            }
        }

        public List<List<String>> findLadders(String start, String end, HashSet<String> dict) {
            HashMap<String, Queue<String>> adjMap = new HashMap<String, Queue<String>>(); // building graph from end to start
            int currLen = 0;
            boolean found = false;
            List<List<String>> res = new ArrayList<List<String>>(); // results
            Queue<String> queue = new LinkedList<String>();              // queue for BFS
            Set<String> unv = new HashSet<String>(dict);                 // unvisited words, delete from here
            Set<String> vst = new HashSet<String>();                     // check words visited during same level
            unv.add(end); // dict may not contain end, so we add it~!@
            queue.offer(start); // search & build from start
            int currLev = 1;
            int nextLev = 0;
            for(String word : unv) {   // all strings in dict + start
                adjMap.put(word, new LinkedList<String>());  // just like clone graph
                // each dict word is a key, including end, except start,
                // because building directed graph from end --> start
                // any ele in val for the key recorded induced from "end", would be functional swh in the path
                // cause terminated once found shortest;
                // but these not traced/triggered from end will ignore because not shortest
            }
            unv.remove(start);
            while( !queue.isEmpty() ){
                String currLadder = queue.poll();  // current word, --> mutate, check dicts, add or not
                for(String nextLadder : getNextLadder(currLadder, unv)){ 
                    if (vst.add(nextLadder)) {  // add to vst set, return true, succeed, vst set didn't contain it before
                        nextLev++;
                        queue.offer(nextLadder);
                    }
                    adjMap.get(nextLadder).offer(currLadder); 
                    if(nextLadder.equals(end) && !found) { // control if start --> end directly, No here
                        found = true;
                        currLen += 2;
                    }
                } 
                if(--currLev == 0){
                    if(found) break;
                    unv.removeAll(vst);  // remove all used string from cur level to avoid next level repeat&infinite loop
                    currLev = nextLev;
                    nextLev = 0;
                    currLen++;
                }
            }
            if (found) {
                LinkedList<String> path = new LinkedList<String>();
                path.addFirst(end);   // add at beginning of list
                //getLadders(start, end, path, res, adjMap, currLen);
                getLadders(start, end, path, res, adjMap);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution result = new Solution();
        String start = "hit";
        String end = "cog";
        String [] s = {"hot","dot","dog","lot","log"};
        HashSet<String> dict = new HashSet<String>(Arrays.asList(s));
        System.out.println("");
        for (String i : dict) {
            System.out.println(i + ", ");
        }
        System.out.println("");
        
        List<List<String>> res = result.findLadders(start, end, dict);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
