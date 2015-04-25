#include <iostream>
#include <cstring>
#include <map>
using namespace std;

const int maxn = 100;
struct Node {
    int key; 
    Node *left, *right, *parent;
};
Node *p, node[maxn];
int cnt;

void init() {
    p = NULL;
    memset(node, '\0', sizeof(node));
    cnt = 0;
}

void create_minimal_tree(Node* &head, Node *parent, int a[], int start, int end){
    if(start <= end){
        int mid = (start + end)>>1;
        node[cnt].key = a[mid];
        node[cnt].parent = parent;
        head = &node[cnt++];
        create_minimal_tree(head->left, head, a, start, mid-1);
        create_minimal_tree(head->right, head, a, mid+1, end);
    }
}

Node* first_ancestor(Node *n1, Node *n2) {
    if (n1 == NULL || n2 == NULL) return NULL;
    map<Node*, bool> m;
    while (n1) {
	m[n1] = true;
	n1 = n1->parent;
    }
    while (n2 && !m[n2]) 
	    n2 = n2->parent;
    return n2;
}

// mine, confusing, should be wrong
/*
Node* first_ancestor1(Node *n1, Node *n2) {
    if (n1 == NULL || n2 == NULL) return NULL;
    Node *p = n2;

    while (n1) {
	while (n2 && n2 != n1) 
	    n2 = n2->parent;
	n2 = p;
	n1 = n1->parent;
    }
    return n2;
}  */


bool father(Node *n1, Node *n2) {
    if (n1 == NULL) return false;
    else if (n1 == n2) return true;
    else return father(n1->left, n2) || father(n1->right, n2);
}

Node* first_ancestor2(Node *n1, Node *n2) {
    if (n1 == NULL || n2 == NULL) return NULL;

    while (n1) {
	if (father(n1, n2)) return n1;	    
	n1 = n1->parent;
    }
    return NULL;
}

// no parent pointer
void first_ancestor3(Node *head, Node *n1, Node *n2, Node* &ans) {
    if (head == NULL || n1 == NULL || n2 == NULL) return;
    if ( head && father(head, n1) && father(head, n2) ) {
	ans = head;
	first_ancestor3(head->left, n1, n2, ans);
	first_ancestor3(head->right, n1, n2, ans);
    }
}

Node* search(Node* head, int x) {
    if (head == NULL) return NULL;
    else if (x == head->key) return head;
    else if (x <= head->key) return search(head->left, x);
    else return search(head->right, x);
}

int main() {
    init();
    int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    Node *head = NULL;
    create_minimal_tree(head, NULL, a, 0, 8);
    Node *n1 = search(head, 3);
    Node *n2 = search(head, 7);
    cout << "keys: " << n1->key << " " << n2->key << endl;

    Node* ans = first_ancestor2(n1, n2);
    cout << "ans->key: " << ans->key << endl;

    Node *ans1 = NULL;
    first_ancestor3(head, n1, n2, ans1);
    cout << "ans->key: " << ans->key << endl;

    return 0;
}
