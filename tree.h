#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;
typedef vector<string> vs;
typedef vector<vector<string> > vvs;

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
/*
void printVI(vi tmp);
void printVVI(vvi tmp);
void printVS(vs tmp);
void printVVS(vvs tmp);
TreeNode* buildTree(int a[], int len);
void preOrder(TreeNode* root);
vector<vector<int> > levelOrder(TreeNode *root);
void levelOrderPrint(TreeNode* root);
*/
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

void printVS(vs tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVS(vvs tmp) {
    cout << endl << "vvs print: " << endl;
    for (int i = 0; i < tmp.size(); ++i)
        printVS(tmp[i]);
    cout << endl;
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

void preOrder(TreeNode* root) {
    if (!root) return;
    cout << root->val << ", ";
    preOrder(root->left);
    preOrder(root->right);
}

vector<vector<int> > levelOrder(TreeNode *root) {
    vector<vector<int> > vvi;
    if (!root) return vvi;
    
    vector<int> vi;
    intNode onenode;
    int idx = 0;
    TreeNode* curr = root;
    bool done = false;
    
    queue<intNode> qi;
    int depth = 1;
    onenode.dep = depth;
    onenode.ptr = root;
    qi.push(onenode);
    int tmp;
    
    int curl;
    while(!qi.empty()) {
        curl = (qi.front()).dep;
        ++depth;
        while( (qi.front()).dep == curl) {
            curr = (qi.front()).ptr;
            if (curr->left || curr->right) {            
                if (curr->left){        
                    onenode.dep = depth;
                    onenode.ptr = curr->left;
                    qi.push(onenode);
                }
                if (curr->right){        
                    onenode.dep = depth;
                    onenode.ptr = curr->right;
                    qi.push(onenode);
                }
            }
            vi.push_back(curr->val);
            qi.pop();        
        }            
        vvi.push_back(vi);
        tmp = vi.size();
        for (int i = 0; i < tmp; ++i) 
            vi.pop_back();
    }
    return vvi;
}
 
void levelOrderPrint(TreeNode* root) {
    queue<TreeNode*> q;
    if (!root) return;
    TreeNode* curr;
    
    q.push(root);
    while ( !q.empty() ) {    
        curr = q.front();
        if (curr->left)
            q.push(curr->left);
        if (curr->right)
            q.push(curr->right);
        cout << curr->val << ", ";
        q.pop();
    }
}

// upsideDownBinaryTree.cpp
// 
