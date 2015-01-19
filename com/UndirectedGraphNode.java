package com;

class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    // {0,1,2    # 1,2    # 2,2}
    // {0, 1, 2 -1, 1, 2 -1, 2, 2};
    public void buildUndirectedGraph(UndirectedGraphNode node, int [] a) {
        int idx = 0;
        

    }
}
