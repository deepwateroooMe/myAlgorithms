#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <cmath>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

struct intNode {
    int dep;
    TreeNode* ptr;
};

void preOrder(TreeNode* root);
TreeNode* buildTree(int a[], int len);
void printVVI(vvi tmp);
void printVI(vi tmp);
void levelOrderPrint(TreeNode* root);

void findSum(TreeNode* root, vector<int> v, int &res) {
    if (!root) return;
    v.push_back(root->val);
    int cnt = 0; int dig = 0;
    if (!root->left && !root->right) {
        dig = v.size() -1;
        for (int i = 0; i < v.size(); ++i)  
            res += v[i]*pow(10, dig--);
        cnt = v.size();
        for (int i = 0; i < cnt; ++i) 
            v.pop_back();
    }
    vector<int> v1(v), v2(v);
    findSum(root->left, v1, res);
    findSum(root->right, v2, res);
}

int pathSum(TreeNode* root) {
    if (!root) return 0;
    else if (root && !root->left && !root->right) return root->val;
    int res = 0;
    vector<int> vi;
    findSum(root, vi, res);
    return res;
}

int main() {
    const int size = 3;
    int a[size] = {1, 2, 3};
    TreeNode* root = buildTree(a, size);
    TreeNode* curr = root;
    levelOrderPrint(curr);

    int result = 0;
    result = pathSum(root);
    
    cout <<  result << endl;

    
    return 0;
}

TreeNode* buildTree(int a[], int len) {
    TreeNode* root;
    TreeNode* curr;
    queue<TreeNode*> q;
    int idx = 0;
    if (idx == 0) {        
        root = new TreeNode(a[idx++]);
        curr = root;
        q.push(curr);
    }
    //++idx;
    while(!q.empty() && idx < len) {
        curr = q.front();
        if (idx % 2 == 1) {            
            if (a[idx] != -1) {                
                curr->left = new TreeNode(a[idx]);
                q.push(curr->left);
            } else 
                curr->left = NULL;
            idx++;
        }
        if (idx % 2 == 0) {                
            if (a[idx] != -1) {                
                curr->right = new TreeNode(a[idx]);
                q.push(curr->right);
            } else 
                curr->right = NULL;
            idx++;
        }
        q.pop();
    }
    return root;
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

void postOrder(TreeNode* root) {
    if (!root) return;
    cout << root->val << ", ";
    postOrder(root->left);
    postOrder(root->right);
}

void printVI(vi tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVI(vvi tmp) {
    cout << endl << "vvi print: " << endl;
    for (int i = 0; i < tmp.size(); ++i)
        printVI(tmp[i]);
    cout << endl;
}

