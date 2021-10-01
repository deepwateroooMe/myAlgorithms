#include <iostream>
#include <cstring>
using namespace std;

const int maxn = 100;

struct Node {
    int key; 
    Node *left, *right, *parent;
};
Node *head, *p, node[maxn];
int cnt;

void init() {
    head = p = NULL;
    memset(node, '\0', sizeof(node));
    cnt = 0;
}

void insert(Node* &head, int x) {
    if (head == NULL) {
	node[cnt].key = x;
	node[cnt].parent = p;
	head = &node[cnt++];
	return;
    }
    p = head;
    if (x < head->key) 
	insert(head->left, x);
    else 
	insert(head->right, x);
}

int d = 0, num = 0, depth[maxn];
void getDepth(Node * head) {
    if (head == NULL) return; 
    ++d;
    getDepth(head->left);
    if ( !head->left && !head->right ) // leaf node
	depth[num++] = d;              // leaf node depth
    getDepth(head->right);
    --d;
}

bool isBalanced(Node* head) {
    if (head == NULL) return true;
    num = 0;
    getDepth(head);

    int min = depth[0];
    int max = depth[0];
    for (int i = 1; i < num; ++i) {
	if ( depth[i] < min ) min = depth[i];
	if (depth[i] > max) max = depth[i];
    }
    if (max - min > 1)
	return false;
    else 
	return true;
}

int main() {
    init();
    int a[] = {5, 3, 8, 1, 4, 7, 10, 2, 6, 9, 11, 12};
    for (int i = 0; i < 12; ++i )
	insert(head, a[i]);
    cout << isBalanced(head) << endl;
    return 0;
}
