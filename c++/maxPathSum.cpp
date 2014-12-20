#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int maxSum(TreeNode* root, int& tmp) {
    if (!root) {    
        tmp = 0;
        return 0;
    }
    if (!root->left && !root->right) {    
        tmp = root->val;
        return root->val;
    }
    int result;
    int ml = 0, mr = 0;
    int msl = 0, msr = 0;
    ml = maxSum(root->left, msl);
    mr = maxSum(root->right, msr);
    tmp = max( max(msl+root->val, root->val),
               max(msr+root->val, root->val) );
    result = max( max(msl+root->val, msl+msr+root->val),
                  max(msr+root->val, msr+msl+root->val) );
    result = max(result, root->val);

    if (root->left)
        result = max(result, ml);
    if (root->right)
        result = max(result, mr);

    return result;
}

int maxPathSum(TreeNode* root) {
    if (!root) return 0;
    int result = 0;
    return maxSum(root, result);
}

void preOrder(TreeNode* root) {
    if (!root) {    
        cout << "#, ";
        return;
    }
    cout << root->val << ", ";
    preOrder(root->left);
    preOrder(root->right);
}

int main() {
    TreeNode* root = new TreeNode(-1);
    root->left =  new TreeNode(0);
    root->right =  new TreeNode(1);
    
    /*
    int a[4] = {0, -2, 0, 2}; 
    TreeNode* root = new TreeNode(a[1]);
    TreeNode* tmp, *curr;
    curr = root;
        
    for (int i = 2; i < 4; ++i){
        if (!(i >> 1) && a[i] != -1) 
        { 
            tmp = new TreeNode(a[i]);
            curr->left = tmp;
            curr = curr->left;
        } else if (!(i >> 1)) {
                curr->left = NULL;
        } else if (a[i] != -1) {            
            tmp = new TreeNode(a[i]);
            curr->right = tmp;
            curr = curr->right;
        } else {
            curr->right = NULL;
        }
        } */
    preOrder(root);
    cout << "maxPathSum: " << maxPathSum(root) << endl;
    
    return 0;
}
