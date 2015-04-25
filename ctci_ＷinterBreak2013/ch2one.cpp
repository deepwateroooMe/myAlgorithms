#include <iostream>
#include <cstring>
using namespace std;

typedef struct node {
    int data;
    node* next;
} node;

bool hash[100];

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
	//p = nd;          // same as followed line
	p = p->next;
    }
    return head;
}

void removeDuplicate1(node* head) {
    if (head == NULL) return;

    node* p = head, *q = head->next;
    hash[head->data] = true;
    
    while(q) {
	if (hash[q->data]) {
	    node* tmp = q; 
	    q = q->next;
	    p->next = q;
	    delete tmp; 
	} else {
	    hash[q->data] = true;
	    p = q;
	    q = q->next;
	}
    }
}

void removeDuplicate2(node* head) {
    if (head == NULL) return;

    node* p = head, *curr = head->next, *prev;
    while(p) {
	prev = p;
	curr = p->next;
	while(curr) {
	    if (curr->data == p->data) {
		node* tmp = curr; 
		prev->next = curr->next;
		curr = curr->next;  // same as: curr = prev->next;
		delete tmp; 
	    } else {
		prev = curr;
		curr = curr->next;
	    }
	}
	p = p->next; 
    }
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
    memset(hash, false, sizeof(hash));
    node *head = init(a, 10);
    print(head);
    //removeDuplicate1(head);
    removeDuplicate2(head);
    print(head);
    return 0;
}
