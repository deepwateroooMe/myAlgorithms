// Sort a linked list using insertion sort.

#include <iostream>
using namespace std;

// * Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
/*
ListNode* mergeSortList(ListNode *head) {
    ListNode *p = head;
    int size = 0;
    while (p) {
        size++;
        p = p->next;
    }
    ListNode* result = mergesort(head, size);
    return result;
}

ListNode* mergesort(ListNode* head, int size) {
    if (size > 1) {
        ListNode* l1 = head;
        int l1size = size / 2;
        int cnt = 0;
        ListNode* l2 = head;
        while (cnt < l1size)  {
            cnt++;
            l2 = l2->next;
        }
        int l2size = size -l1size;
        mergesort(l1, l1size);
        mergesort(l2, l2size);
        ListNode* result = merge_list(l1, l1size, l2, l2size);
        return result;
    }
    return head;
}

ListNode* merge_list(ListNode* l1, int l1size, ListNode* l2, int l2size) {
    int i, j, tmp;
    i = j = 0;
    while (i < l1size && j < l2size) {
        if (*l1 > *l2) {
            tmp = *l1;
            *l1 = *l2;
            *l2 = tmp;
            i++;
            l1 = l1->next;
        } else {


        }


    }

}
*/
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
    ListNode * tmp = head;
    while (tmp != NULL) {
        cout << tmp->val << ", ";
        tmp = tmp->next;
    }
    cout << endl;
}

ListNode* sortList(ListNode* head) {
    if (!head || !head->next) return head;
    ListNode *mid = head, *tmp = head->next;
    while (tmp && tmp->next) {  // slow fast ptrs
        mid = mid->next;
        tmp = tmp->next->next;
    }
    tmp = mid->next;  // pointing to head of second half
    mid->next = NULL; // cut from the middle
    ListNode *l1 = sortList(head);
    ListNode *l2 = sortList(tmp);
    
    // insert l2 to l1
    ListNode **curr = &l1;
    ListNode *entry;
    while (l2 && *curr) {
        entry = *curr;
        if (l2->val < entry->val) { // l1->val < l2->val
            *curr = l2;
            l2 = entry;
        }
        // l1->val > l2->val
        curr = &(*curr)->next;
    }
    if (l2) *curr = l2;
    return l1;
}

int main() {
    int a[] = {2, 1, 3, 7};
    int n = 4;
    ListNode *head = init(a, n);
    printList(head);

    ListNode *p = sortList(head);
    printList(p);
    return 0;
}
