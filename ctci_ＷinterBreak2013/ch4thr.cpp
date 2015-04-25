#include <iostream>
#include <cstring>
using namespace std; 

const int maxn = 100;

struct Node {
    int key; 
    Node *left, *right;
    Node *parent;
};
Node *p, node[maxn];
int cnt;

void init() {
    p = NULL;
    memset(node, '\0', sizeof(node));
    cnt = 0;
}

void create_minimal_tree(Node* &head, Node *parent, int a[], int start, int end) {
    if (start <= end) {
	int mid = (start + end) / 2;
	node[cnt].key = a[mid];
	node[cnt].parent = parent;
	head = &node[cnt++];
	create_minimal_tree(head->left, head, a, start, mid-1);
	create_minimal_tree(head->right, head, a, mid+1, end);
    }
}

int height(Node* head) {
    if (head == NULL) return 0;
    return max( height(head->left), height(head->right) ) + 1;
}

int main() {
    init();
    int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    Node* head = NULL;
    create_minimal_tree(head, NULL, a, 0, 8);
    cout << height(head) << endl;
    return 0;
}
