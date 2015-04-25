#include <iostream>
#include <cstring>
using namespace std;

const int maxn = 100;
struct Node {
    int key; 
    Node *left, *right, *parent;
};
Node node[maxn];
int cnt; 

void init() {
    memset(node, '\0', sizeof(node));
    cnt = 0;
}

void create_minimal_tree(Node * &head, Node *parent, int a[], int start, int end) {
    if (start <= end ) {
	int mid = (start + end) >> 1;
	node[cnt].key = a[mid];
	node[cnt].parent = parent;
	head = &node[cnt++];
	create_minimal_tree(head->left, head, a, start, mid-1);
	create_minimal_tree(head->right, head, a, mid+1, end);
    }
}

// if two tree matches
bool match(Node *n1, Node *n2) {
    if (n1 == NULL && n2 == NULL) return true;
    else if (n1 == NULL || n2 == NULL) return false;
    else if (n1->key != n2->key) return false;
    else 
	return match(n1->left, n2->left) && match(n1->right, n2->right); 
}

bool subtree(Node *n1, Node *n2) {
    if (n1 == NULL) return false;
    else if (n1->key == n2->key) {
	if ( match(n1, n2) ) return true;
    }
    else return subtree(n1->left, n2) || subtree(n1->right, n2);
}

bool contain_tree(Node *n1, Node *n2) {
    if (n2 == NULL) return true;
    else return subtree(n1, n2);
}

int main() {
    init();
    int a1[] = {0, 1, 2, 3, 4, 5, 6};
    int a2[] = {0, 1, 2};
    Node *r1 = NULL, *r2 = NULL;
    create_minimal_tree(r1, NULL, a1, 0, 6);
    create_minimal_tree(r2, NULL, a2, 0, 2);
    if ( contain_tree(r1, r2) ) 
	cout << "tree r1 contains tree r2" << endl;
    else 
	cout  << "tree r1 does not contain tree r2" << endl;

    return 0;
}
