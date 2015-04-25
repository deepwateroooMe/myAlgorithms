#include <iostream>
#include <map>
using namespace std;

typedef struct node {
    int data;
    node* next;
} node;

node* init(int a[], int n, int m) {
    node *head, *p, *q; 
    for (int i = 0; i < n; ++i) {
	node * nd = new node();
	nd->data = a[i];
	if (i == m) q = nd; // mark first node in the loop
	if (i == 0) {
	    head = p = nd; // set head
	    continue;
	}
	p->next = nd;
	p = p->next;
    }
    p->next = q;  // point back to beginning of loop
    return head;
}

node* loopstart(node* head) {
    if (head == NULL) return NULL;
    node *fast = head, *slow = head;
    while (fast && fast->next) {
	fast->next = fast->next->next;
	slow = slow->next;
	if (fast == slow) break;
    }
    if (!fast || !fast->next) return NULL;
    slow = head;
    while(fast != slow) {
	fast = fast->next;
	slow = slow->next;
    }
    return fast;
}

map<node*, bool> hash;
node* loopstart1(node* head) {
    while(head) {
	if (hash[head]) return head;
	else {
	    hash[head] = true;
	    head = head->next;
	}
    }
    return head;  // don't understand this one
}

int main() {
    int n = 10, m = 9;  // m < n
    int a[] = {3, 2, 1, 3, 5, 6, 2, 6, 3, 1};
    node *head = init(a, n, m);
    node* curr = loopstart(head);
    //node* curr = loopstart1(head);
    if (curr) 
	cout << curr->data << endl;

    return 0;
}

// my original, hash with nodeptr->data as key
bool hash[100];
node* loopstart2(node* head) {
    node* curr = head; 
    while (!hash[curr->data]) {
	hash[curr->data] = true;
	curr = curr->next;
    }
    return curr;
} 

