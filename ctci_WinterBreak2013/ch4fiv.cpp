#include <iostream>
#include <cstring>
using namespace std;

const int maxn = 100;
struct Node {
    int key; 
    Node *left, *right, *parent;
}; 
Node* p, node[maxn];
int cnt; 

void init() {
    p = NULL;
    memset(node, '\0', sizeof(node));
    cnt = 0;
}

void create_minimal_tree(Node* &head, Node *parent, int a[], int start, int end) {
    if (start <= end) {
	int mid = (start + end) >> 1;
	node[cnt].key = a[mid];
	node[cnt].parent = head;
	head = &node[cnt++];
	create_minimal_tree(head->left, head, a, start, mid-1);
	create_minimal_tree(head->right, head, a, mid+1, end);
    }
}

Node* minimal(Node* head) {
    if (head == NULL) return NULL;
    while (head->left)
	head = head->left;
    return head;
}

Node* successor (Node* ptr) {
    if (ptr == NULL) return NULL;
    if (ptr->right)
	return minimal(ptr->right);

    Node* p = ptr->parent;
    while (p && p->right == ptr) {
	ptr = p;
	p = p->parent;
    }
    return p;
}

int main() {
    int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    init();
    Node *head = NULL;
    create_minimal_tree(head, NULL, a, 0, 8);
    cout << "the head is " << head->key << endl;
    cout << "the successor of head is " << (successor(head))->key << endl;
    return 0;
}
