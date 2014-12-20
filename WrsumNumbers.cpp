#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void printList(TreeNode* head);
TreeNode* buildList(int a[], int n);
void levelOrderPrint(TreeNode* root);

int sumNumbers(TreeNode *root) {
        
}

int main()
{



    return 0;
}


void levelOrderPrint(TreeNode* root) {
    queue<TreeNode*> q;
    if (!root) return;
    TreeNode* curr;
    
    q.push(root);
    while ( !q.empty() ) {    
        curr = q.front();
        if (curr) {
            if (curr->left && curr->right) {        
                q.push(curr->left);
                q.push(curr->right);
            } else if (curr->left && !curr->right) {
                q.push(curr->left);
                q.push(NULL);
            } else if (!curr->left && curr->right) {
                q.push(NULL);
                q.push(curr->right);
            } 
            cout << curr->val << ", ";                
        } else 
            cout << "#, ";
        q.pop();
    }
}

TreeNode* buildList(int a[], int n) {
    TreeNode* prev, *curr;
    for (int i = 0; i < n; ++i) {
        if (i == 0) {
            prev = new TreeNode(a[i]);
            curr = prev;
        } else  {
            curr->left = new TreeNode(a[i]);
            curr = curr->left;
        }
    }
    return prev;
}

void printList(TreeNode* head){
    while(head)  {
        cout << head->val << ", " << endl;
        head = head->left;
    }
}
