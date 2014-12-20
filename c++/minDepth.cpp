#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int depth = 0;
int dep[1000000];
int cnt = 0;

void getDepth(TreeNode* root) {
    if (!root) return;
    ++depth;
    getDepth(root->left);
    if (!root->left && !root->right) 
        dep[cnt++] = depth;
    getDepth(root->right);
    --depth;
}

int minDepth(TreeNode *root) {
    if (!root) return 0;
    if (root && (!root->left && !root->right)) return 1;

    getDepth(root);
    int mindep = dep[0];
    for (int i = 0; i < cnt; ++i) {
        cout << "dep[" << i << "]: " << dep[i] << endl;
        
        if (dep[i] < mindep) 
            mindep = dep[i];
    }
    return mindep;
}

void preOrder(TreeNode* root) 
{
    if (!root) return ;
    cout << root->val << endl;
    preOrder(root->left);
    preOrder(root->right);
}

int main() {
    char a[2] = {'1', '2'};
    TreeNode* root = new TreeNode(1);
    TreeNode* tmp;
    
    for (int i = 1; i < 2; ++i){
        if (a[i+1] != '#')
            tmp = new TreeNode(2);
        else tmp = NULL;
        
        if (i >> 1)
            root->left = tmp;
        else
            root->right = tmp;
    }
    //preOrder(root);

    cout << minDepth(root) << endl;
    
    return 0;
}
