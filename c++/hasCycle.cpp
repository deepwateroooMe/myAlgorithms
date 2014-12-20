#include <iostream>
using namespace std;

  struct ListNode {
      int val;
      ListNode* next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
bool hasCycle(ListNode *head) {
    if (head == NULL) return false;

    ListNode* fast = head, *slow = head;
    while(fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) break;
    }

    if (!fast || !fast->next) return false;
    return true;
}

int main() {

    
    return 0;
}
