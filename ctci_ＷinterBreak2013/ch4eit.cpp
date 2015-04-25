#include <iostream>
#include <vector>
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

void create_minimal_tree(Node* &head, Node *parent, int a[], int start, int end) {
    if (start <= end) {
	int mid = (start + end) >> 1;
	node[cnt].key = a[mid]; 
	node[cnt].parent = parent; 
	head = &node[cnt++];
	create_minimal_tree(head->left, head, a, start, mid-1);
	create_minimal_tree(head->right, head, a, mid+1, end);
    }
}

// method 1: with pointer pointing to parent
void print(Node *head, int level) {
    vector<int> path; 
    for (int i = 0; i < level; ++i) {
	path.push_back(head->key);
	head = head->parent;
    }

    vector<int>::iterator it;
    /*for (it = path.end(); it != path.begin(); --it) 
          cout << *it << endl;  */ // somewhere here still WRONG!!!
    while ( !path.empty() ) {
	cout << path.back() << " ";
	path.pop_back();
    }
    cout << endl;
}

void find_sum(Node *head, int sum) {
    if (head == NULL) return;

    Node *ptr = head;
    int val = 0;

    for (int i = 1; ptr != NULL; ++i ) {
	val += ptr->key;
	if (val == sum) 
	    print(head, i);
	ptr = ptr->parent;
    }
    find_sum(head->left, sum);
    find_sum(head->right, sum);
}


// method 2: without pointer pointing to parent, complicated
void print1(vector<int> v, int level) {
    for (int i = level; i < v.size(); ++i)
	cout << v.at(i) << " ";
    cout << endl;
}

void find_sum1(Node *head, int sum, vector<int> v, int level) {
    if (head == NULL) return;
    v.push_back(head->key);

    int val = 0;
    for (int i = level; i > -1; --i ) {
	val += v.at(i);
	if (val == sum) 
	    print1(v, i);
    }
    vector<int> v1(v), v2(v);
    find_sum1(head->left, sum, v1, level+1);
    find_sum1(head->right, sum, v2, level+1);
}


int main() {
    init();
    int a[] = {4, 3, 8, 5, 2, 1, 6};
    Node *head = NULL;
    create_minimal_tree(head, NULL, a, 0, 6);
    //find_sum(head, 8);
    vector<int> v;
    find_sum1(head, 8, v, 0);
    return 0;
}
