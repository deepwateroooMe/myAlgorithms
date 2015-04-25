#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode *head);
ListNode* buildList(int a[], int n);

ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    if (headA == NULL || headB == NULL) return NULL;
    ListNode *p1, *p2;
    /*
    // return NULL earlier
    p1 = headA;
    if (p1->val == headB->val) return headB;
    while (p1->next != NULL && p1->val != headB->val) {        
        p1 = p1->next;
    }
    if (p1->next != NULL) return headB;  // one case
    p2 = headB;
    while (p2->next != NULL) {
        if (p2->val == headA->val) return headA;
    }
    if (p2->val != p1->val) return NULL;
    */
    
    // get pointer    
    p1 = headA;
    p2 = headB;
    while (p1 != NULL && p2 != NULL && p1 != p2) {
        p1 = p1->next;
        p2 = p2->next;
        if (p1 == p2) return p1;
        if (p1 == NULL) p1 = headB;
        if (p2 == NULL) p2 = headA;
    }
    return p1;
    /*    
    while (p1->next != NULL && p2->next != NULL) {        
            if (p1->val == p2->val) return p1;
    }
    if (p1->next == NULL) p1 = headB;
    else if (p2->next == NULL) p2 = headA;

    while (p1->next != NULL && p2->next != NULL) {        
        if (p1->val == p2->val) return p1;
    }
    if (p2->next == NULL) p2 = headA;
    else if (p1->next == NULL) p1 = headB;

    while (p1->next != NULL && p2->next != NULL) {        
        if (p1->val == p2->val) return p1;
    }
    return NULL;
    */
    // my methods are just way too complicated!!!
}

int main(){
    int a[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22};        
    int n = 11;
    ListNode *al, *bl;
    al = buildList(a, n);
    bl = new ListNode(1);
    printList(getIntersectionNode(al, bl));
        
    return 0;
}

ListNode* buildList(int a[], int n) {
    if (n == 0) return NULL;
    ListNode *head, *tmp, *cur;
    head = new ListNode(a[0]);
    cur = head;
    for (int i = 1; i < n; ++i) {        
        tmp  = new ListNode(a[i]);
        cur->next = tmp;
    }
    return head;
}

void printList(ListNode *head) {
    ListNode* tmp = head;
    if (head == NULL) cout << "no intersection";
    while (tmp != NULL) {        
            cout << tmp->val << ", ";
            tmp = tmp->next;
    }
    cout << endl;
}
