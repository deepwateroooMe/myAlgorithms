#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode* head);
ListNode* buildList(int a[], int n);

ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
    if (l1 == NULL && l2 == NULL) return NULL;
    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;

    ListNode* head, *one, *two, *curr;
    if (l1->val <= l2->val) {
        head = l1;
        one = head->next;
        two = l2;
    } else  {
        head = l2;
        two = head->next;
        one = l1;
    }    

    curr = head;
    while (one != NULL && two != NULL ) {
        while (one && two && one->val < two->val) {
            curr->next = one;
            curr = curr->next;
            one = one->next;
        }
        while(one && two && one->val == two->val) {
            curr->next = one;
            curr = curr->next;
            one = one->next;
            curr->next = two;
            curr = curr->next;
            two = two->next;
        }
        while(one && two && one->val > two->val) {
            curr->next = two;
            curr = curr->next;
            two = two->next;
        }
    }

    if (one == NULL && two == NULL) return head;

    if (one == NULL) 
        curr->next = two;
    else if (two == NULL)
        curr->next = one;
    return head;    
}


int main() {
    int a[] = {-9, 3};
    int b[] = {5, 7};

    ListNode *l1, *l2, *head;
    l1 = buildList(a, 2);
    l2 = buildList(b, 2);
    
    head = mergeTwoLists(l1, l2);
    printList(head);

    return 0;
}

ListNode* buildList(int a[], int n) {
    ListNode* prev, *curr;
    
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            prev = new ListNode(a[i]);
            curr = prev;
        } else  {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }
    return prev;
}

void printList(ListNode* head){
    while(head)  {
        cout << head->val << ", " << endl;
        head = head->next;
    }
}
