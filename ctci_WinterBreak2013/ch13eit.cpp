typedef map<Node*, Node*> NodeMap;

Node* copy_recursive(Node* curr, NodeMap &nodeMap) {
    if (curr == NULL) return NULL;

    NodeMap::iterator i = nodeMap.find(curr);
    if ( i != nodeMap.end() ) {
	// we've been here before, return the copy
	return i->second;
    }
    Node *node = new Node;
    nodeMap[curr] = node; // map current node before traversing links
    node->ptr1 = copy_recursive(node->ptr1, nodeMap);
    node->ptr2 = copy_recursive(node->ptr2, nodeMap);
    return node;
}

Node* copy_structure(Node* root) {
    NodeMap nodeMap;  // we will need an empty map
    return copy_recursive(root, nodeMap);
}
