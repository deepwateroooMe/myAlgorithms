#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
ListNode* buildList(int a[], int n);

// Normal reverse, head and tail will be switched after return
void reverse(ListNode* head, ListNode* tail){
    // tail will turn out to be new head
    // head will turn out to be new tail
    if (head == tail)
        return;
    // prev record the head
    ListNode *prev, *curr = head, *next = head->next;
    while(curr != tail){
        curr->next = prev;
        prev = curr;
        curr = next;
        next = curr->next;
    }
    curr->next = prev;
}

ListNode* reverseKGroup(ListNode* head, int k) {
    if (!head)
        return NULL;
    // don't even need the below !!
    //else if (k == 1 || (head && !head->next && k >= 1) ) return head;
    
    ListNode *prevHead = NULL, *prevTail = NULL;
    ListNode *curr = head, *currHead = NULL; // currHead k fragment's head
    int c = 0;

    while(curr){
        ++c;
        ListNode* next = curr->next;
        if (!currHead){
            currHead = curr;
            c=1;
        } 
        
        if (c == k) {
            // Within each group, do a normal reverse
            reverse(currHead, curr);  // loops for every k nodes fragment
            
            // Link group with previous group
            if (!prevHead)
                prevHead = curr;  // previous reversed head
            if (prevTail)
                prevTail->next = curr;
            prevTail = currHead;  // previous reversed tail

            // Reset group count
            currHead = NULL;
        }
        curr = next;
    }
    if (prevTail){
        prevTail->next = currHead;
    }
    return prevHead == NULL ? head : prevHead;
}

int main() {
    int n = 2;
    int a[] = {1, 2};        
    ListNode* tmp = buildList(a, n);
    ListNode* result = reverseKGroup(tmp, 2);

    while(result) {
        cout << result->val << ", ";
        result = result->next;
    }
    cout << endl;
    
    return 0;
}

ListNode* buildList(int a[], int n) {
    ListNode* head, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0)  {
            head = new ListNode(a[i]);
            curr = head;
        } else {
            curr->next = new ListNode(a[i]);
            curr = curr->next;
        }
    }
    return head;
}
