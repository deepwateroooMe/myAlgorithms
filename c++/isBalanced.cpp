#include <iostream>
#include <vector>
#include <stack>
#include <cstdlib>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int depth = 0;
int dep[1000];
int cnt = 0;

int getDepth(TreeNode* root, bool &result) {
    if (!root) return 0;
    if (!result) return 0;

    int ldep = getDepth(root->left, result);
    int rdep = getDepth(root->right, result);
    if (!result) return 0;

    result = abs(ldep - rdep) <= 1;
    return max(ldep, rdep) + 1;
}

bool isBalanced(TreeNode *root) {
    bool result = true;
    getDepth(root, result);
    return result;
}

void preOrder(TreeNode* root) 
{
    if (!root) 
    {
        cout << "#\t" ;
        return;
    }

    cout << root->val << "\t";
    preOrder(root->left);
    preOrder(root->right);
}

int main() {
    int a[4] = {-1, 2, -1, 3};
    TreeNode* root = new TreeNode(1);
    TreeNode* tmp, *curr;
    curr = root;
        
    for (int i = 0; i < 4; ++i){
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
    }
    preOrder(root);
    cout << isBalanced(root) << endl;
    
    return 0;
}
