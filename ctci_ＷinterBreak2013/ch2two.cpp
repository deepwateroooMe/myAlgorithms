#include <iostream>
using namespace std;

typedef struct node {
    int data;
    node* next;
} node;

node* init(int a[], int n) {
    node *head, *p; 
    for (int i = 0; i < n; ++i) {
	node * nd = new node();
	nd->data = a[i];
	if (i == 0) {
	    head = p = nd; // set head
	    continue;
	}
	p->next = nd;
	p = p->next;
    }
    return head;
}

// traverse the list twice, my method
int findNthToLast1(node* head, int n) {
    if (head == NULL) return 0;
    int m, cnt = 1;
    node *prev = head, *curr = prev->next;
    while(curr) {
	prev = curr; 
	curr = curr->next;
	++cnt;
    }
    m = cnt;
    cnt = 0;
    prev = head;
    curr = prev->next;
    if (curr==NULL && n == 1) 
	return head->data;

    while(curr) {
	if (cnt == m - n)
	    return prev->data;
	else {
	    prev = curr; 
	    curr = curr->next;
	    ++cnt;
	}
    }
}

node* pp; 
int nn;

void findNthToLast2(node* head) {
    if (head == NULL) return;
    findNthToLast2(head->next);
    if (nn==1) 
	pp = head;
    --nn;
}

// two pointer with n nodes separated
node* findNthToLast3(node* head, int n) {
    if ( (head == NULL) || n < 1) return NULL; // forgot to consider

    node * prev = head, *curr = head;
    while (n > 0 && curr) {
	curr = curr->next;
	--n;
    }
    if (n > 0) return NULL;  // forgot to consider

    while(curr) {
	prev = prev->next;
	curr = curr->next;
    }
    return prev;
}

void print(node* head) {
    node * curr = head;
    while (curr) {
	cout << curr->data << ' ';
	curr = curr->next;
    }
    cout << endl;
}

int main() {
    int n = 10;
    int a[] = {3, 2, 1, 3, 5, 6, 2, 6, 3, 1};
    node *head = init(a, 10);
    print(head);

    cout << findNthToLast1(head, 4) << endl;

    node *p = findNthToLast3(head, 4);
    if (p) cout << p->data << endl;
    else cout << "the length of link is not long enough" << endl;
	
    nn = 4;
    findNthToLast2(head);
    if (pp) cout << pp->data << endl;
    
    return 0;
}
