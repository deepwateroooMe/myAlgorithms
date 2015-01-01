#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include "tree.h"

using namespace std;

// try recursive method
// https://oj.leetcode.com/discuss/17745/recursive-solution-not-the-best-but-it-works
TreeNode* newRoot = NULL;
bool found = false;
TreeNode *upsideDownBinaryTree(TreeNode *root) {
    if (root == NULL) return NULL;
    if (root->left == NULL) return root;
    recursive(root);
    return newRoot;
}

void recursive(TreeNode* root) {
    if (root->left == NULL) return;
    recursive(root->left);
    if (root->left->left == NULL) {
        if (!found) {
            newRoot = root->left;
            found = true;
        }
        root->left->left = root->right;
        root->right = NULL;
        root->left->right = root;
        root->left = NULL;
    }
}

// iterative easier to understand
TreeNode *upsideDownBinaryTree1(TreeNode *root) {
    if (root == NULL || root->left == NULL) return root;
    TreeNode *curr;
    stack<TreeNode*> s;
    curr = root;
    s.push(curr);
    curr = curr->left;
    while (curr != NULL) {  // different from !curr
        s.push(curr);
        curr = curr->left;
    }
    
    TreeNode *head;
    head = s.top();
    s.pop();  
    TreeNode *top;
    curr = head;
    while (!s.empty()) {
        top = s.top();
        s.pop();
        top->left = NULL;
        if (top->right != NULL) {
            curr->left = top->right;
            top->right = NULL;
        }
        curr->right = top;
        curr = curr->right;
        curr->right = NULL;
    }
    return head;
}

int main() {
    const int size = 3;
    int a[size] = {1, 2, -1};
    
    TreeNode* root;
    TreeNode* tmp;
    TreeNode* curr;
    int cnt = 0;
    root = buildTree(a, size);
    preOrder(root);
    cout << endl;

    tmp = upsideDownBinaryTree(root);
    preOrder(tmp);
    cout << endl;

    return 0;
}
