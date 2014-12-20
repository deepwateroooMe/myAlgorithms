#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

typedef vector<TreeNode*> vi;

void printList(TreeNode* head);
TreeNode* buildList(int a[], int n);
void levelOrderPrint(TreeNode* root);

vector<TreeNode*> genIndiTree(int l, int r) {
    vector<TreeNode*> result;
    if (l > r)  {
        result.push_back(NULL);
        return result;
    }
    for (int i = l; i <= r; ++i) {
        vector<TreeNode*> left = genIndiTree(l, i-1);
        vector<TreeNode*> right = genIndiTree(i+1, r);
        for (int x = 0; x < left.size(); ++x) {
            for (int y = 0; y < right.size(); ++y) {
                TreeNode* root = new TreeNode(i);
                root->left = left[x];
                root->right = right[y];
                result.push_back(root) ;
            }
        }
    }
    return result;
}

vector<TreeNode*> recoverTree(int n) {
    vector<TreeNode*> result;
    if (n ==0)  {
        result.push_back(NULL);
        return result;
    }
    return genIndiTree(1, n);
}

int main() {
    int n = 3;
    vi root = recoverTree(n);
    for(int i = 0; i < root.size(); ++i)  {
        cout << i << ": " << endl;
        levelOrderPrint(root[i]);
        cout << endl;
    }
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
