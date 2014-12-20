// Sort a linked list using insertion sort.

#include <iostream>
using namespace std;

// * Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
ListNode* init(int a[], int n) {
    ListNode* head = new ListNode(a[0]);
    ListNode *curr = head;

    for (int i = 1; i < n; ++i) {
	ListNode* tmp = new ListNode(a[i]);
	curr->next = tmp;
	curr = curr->next;
    }
    return head;
}

void printList(ListNode *head) {
    if (head == NULL) return;
    while (head != NULL) {
	cout << head->val << endl;
	head = head->next;
    }
    cout << endl;
}

ListNode* insertionSortList(ListNode *head) {
    if (head == NULL) return head;

    ListNode *p = head->next;
    int tmp;
    ListNode *nodetmp, *prev, *curr;
    while (p) {
	prev = head;
	curr = head->next;
	while (curr && curr != p) {
	    if (p->val < prev->val) {
		tmp = prev->val;
		prev->val = p->val;
		p->val = tmp;
	    } 
	    if (p->val >= prev->val && p->val < curr->val) {
		tmp = curr->val;
		curr->val = p->val;
		p->val = tmp;
	    }
	    prev = curr;
	    curr = curr->next;
	}
	if (curr == p && prev->val > curr->val) {
	    if (prev == head) {
		tmp = prev->val;
		prev->val = curr->val;
		curr->val = tmp;
	    } else {
		nodetmp = curr;
		prev->next = curr->next;
		curr = curr->next;
		delete nodetmp;
		p = p->next;
	    }
	} else 
	    p = p->next;
	prev = head;
	curr = head->next;
    }
    return head;
}

int main() {
    int a[] = {2, 3, 4, 1};
    int n = 4;
    ListNode *head = init(a, n);
    printList(head);

    ListNode *p = insertionSortList(head);
    printList(p);
    return 0;
}


/*

  
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };

class Solution {
public:
    ListNode *insertionSortList(ListNode *head) {
            if (head == NULL) return head;

    ListNode *p = head->next;
    int tmp;
    ListNode *nodetmp, *prev, *curr;
    while (p) {
	prev = head;
	curr = head->next;
	while (curr && curr != p) {
	    if (p->val < prev->val) {
		tmp = prev->val;
		prev->val = p->val;
		p->val = tmp;
	    } 
	    if (p->val >= prev->val && p->val < curr->val) {
		tmp = curr->val;
		curr->val = p->val;
		p->val = tmp;
	    }
	    prev = curr;
	    curr = curr->next;
	}
	if (curr == p && prev->val > curr->val) {
	    if (prev == head) {
		tmp = prev->val;
		prev->val = curr->val;
		curr->val = tmp;
	    } else {
		nodetmp = curr;
		prev->next = curr->next;
		curr = curr->next;
		delete nodetmp;
		p = p->next;
	    }
	} else 
	    p = p->next;
	prev = head;
	curr = head->next;
    }
    return head;

    }
};


 */
