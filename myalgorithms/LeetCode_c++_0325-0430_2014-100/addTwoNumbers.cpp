#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* buildList(int a[], int n);

ListNode *addTwoNumbers(ListNode *l1, ListNode* l2) {
    if (!l1 && !l2) return NULL;
    else if (!l1 && l2) return l2;
    else if (l1 && !l2) return l1;

    ListNode* head, *curr;
    int result, resi = 0, roll = 0;
    resi = (l1->val + l2->val) % 10;
    roll = (l1->val + l2->val) / 10;
    head = new ListNode(resi);
    curr = head;
    while(l1->next && l2->next) {
        l1 = l1->next;
        l2 = l2->next;
        result = l1->val + l2->val + roll;
        resi = result % 10;
        roll = result / 10;
        curr->next = new ListNode(resi);
        curr = curr->next;
    }
    if (l1->next)
        curr->next = l1->next;
    else if (l2->next)
        curr->next = l2->next;
    while (roll > 0)  {
        if (!curr->next)  {
            if (roll > 9) {            
                resi = roll % 10;
                roll /= 10;
                curr->next = new ListNode(resi);
                curr = curr->next;
                curr->next = new ListNode(roll);
            } else
                curr->next = new ListNode(roll);
            curr = curr->next;
            roll = 0;
        } else { // curr->next
            result = roll + curr->next->val;
            resi = result % 10;
            roll = result / 10;
            curr->next->val = resi;
            curr = curr->next;
        }
    }
    return head;
}

int main() {
    int n = 3;
    int a[] = {3, 7};
    int b[] = {9, 2};
    ListNode* l1 = buildList(a, 2);
    ListNode* l2 = buildList(b, 2);

    cout << endl;
    ListNode* curr = l1;
    while(curr)  {
        cout << curr->val << ", ";
        curr = curr->next;
    }
    cout << endl;
    curr = l2;
    while(curr)  {
        cout << curr->val << ", ";
        curr = curr->next;
    }
    cout << endl;

    ListNode* result = addTwoNumbers(l1, l2);

    cout << endl;
    while(result)  {
        cout << result->val << ", ";
        result = result->next;
    }
    return 0;
}

ListNode* buildList(int a[], int n) {
    ListNode* head, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0)  {
            head = new ListNode(a[i]);
            curr = head;
        } else  {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }
    return head;
}



