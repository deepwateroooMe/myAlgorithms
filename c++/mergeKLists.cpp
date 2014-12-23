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

// referred to https://oj.leetcode.com/discuss/9279/a-java-solution-based-on-priority-queue
// rewrite into c++
ListNode* mergeTwoLists(ListNode *l1, ListNode *l2) {
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

ListNode *mergeKLists(vector<ListNode *> &lists) {
    if (lists.size() == 0) return NULL;
    if (lists.size() == 1) return lists[0];
    if (lists.size() == 2) return mergeTwoLists(lists[0], lists[1]);
    vector<ListNode*> l1(lists.begin(), lists.begin() + lists.size()/2), l2(lists.begin() + lists.size()/2, lists.end());
    return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
}

int main(){


    return 0;
}
