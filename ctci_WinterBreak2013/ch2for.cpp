#include <iostream>
#include <cmath>
using namespace std;

typedef struct node{
    int data;
    node *next;
}node;

node* init(int a[], int n){
    node *head, *p;
    for(int i=0; i<n; ++i){
        node *nd = new node();
        nd->data = a[i];
        if(i==0){
            head = p = nd;
            continue;
        }
        p->next = nd;
        p = p->next;
    }
    return head;
}

// single list, return single list
node* sumAdd(node* head) {
    if (head == NULL || head->next == NULL) return NULL;

    node *prev = head, *curr = head->next;
    int a = prev->data, cnt = 0;
    while(curr->next) {
	prev = prev->next;
	curr = curr->next->next;
	++cnt;
	a += prev->data * pow(10, cnt);
    }

    curr = prev->next;
    int b = curr->data;
    cnt = 0;
    while(curr->next) {
	curr = curr->next;
	++cnt;
	b += curr->data * pow(10, cnt);
    }

    int result = a + b;
    if (result >= 0) {
	node* newhead = new node();
	newhead->data = result % 10;
	newhead->next = NULL;

	result = result / 10;
	node * p = newhead;

	while (result > 0) {
	    node* curr = new node();
	    curr->data = result % 10;
	    curr->next = NULL;
	    p->next = curr;
	    p = p->next;
	    result = result / 10; 
	}
	return newhead;
    } else
	return NULL;
}

// double lists, return a list
node* addlink(node *p, node *q){
    if (p == NULL) return q; 
    if (q == NULL) return p; 

    int result = 0;
    node *curr = NULL, *newhead;
    while (p && q) {
	result += p->data + q->data;
	node* tmp = new node();
	tmp->data = result % 10;
	tmp->next = NULL;
	if (curr) {
	    curr->next = tmp;
	    curr = curr->next;
	} else
	    newhead = curr = tmp;
	p = p->next;
	q = q->next;
	result = result / 10;
    }

    node* r;
    if (p) r = p;
    else r = q;
    while (r) {
	result += r->data;
	node* tmp = new node();
	tmp->data = result % 10;
	tmp->next = NULL;
	curr->next = tmp;
	curr = curr->next;
	r = r->next;
	result = result / 10;
    }

    if (result > 0) { //`还有进位时`
	node* tmp = new node();
	tmp->data = result;
	tmp->next = NULL;
	curr->next = tmp;
    }
    return newhead;
}

void print(node *head){
    while(head){
        cout<<head->data<<" ";
        head = head->next;
    }
    cout<<endl;
}

int main(){
    int n = 6;
    int a[] = {3, 1, 4, 5, 9, 2};
    node *head = init(a, n);
    node* curr = sumAdd(head);
    if (curr) print(curr);
    else cout << "fail!!!" << endl;
    cout << endl;

    int n2 = 4;
    int a2[] = {1, 2, 9, 3};
    int m = 3;
    int b2[] = {9, 9, 2};

    node *p = init(a2, n2);
    node *q = init(b2, m);
    node *res = addlink(p, q);
    if(p) print(p);
    if(q) print(q);
    if(res) print(res);

    return 0;
}
