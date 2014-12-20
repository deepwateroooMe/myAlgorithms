#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;
typedef vector<string> vs;

struct node {
    string val;
    node *left, *right;
    node(string x) : val(x), left(NULL), right(NULL){}
};

void levelOrderPrint(node* root);

node* buildTree(vector<string> &a) {
    int len = a.size();
    node* root;
    node* curr;
    int idx = len-1;

    if (idx == len-1) {        
        root = new node(a[--idx]);
        curr = root;
    }
    while( idx >= 0) {
        if ( (len-idx) % 2 )
            curr->left = new node(a[idx]);
        else
            curr->right = new node(a[idx]);
        --idx;
    }
        
    if (idx % 2 == 1) {            
        curr->left = new node(a[idx]);
        q.push(curr->left);
        --idx;
    }
    if (idx % 2 == 0) {        
        curr->right = new node(a[idx]);
        q.push(curr->right);
        --idx;
    }
    q.pop();
}
return root;
}

int evalRPN(vector<string> &tokens) {
    node* root = buildTree(tokens);
    levelOrderPrint(root);
    cout << "got here 2" << endl;
    return 0;
}

int main(){
    int n = 5;
    string a[] = {"2", "1", "+", "3", "*"};
    vs tokens;
    for(int i = 0; i < n; ++i)
        tokens.push_back(a[i]);
    
    evalRPN(tokens);
    
    

    return 0;
}

void levelOrderPrint(node* root) {
    queue<node*> q;
    if (!root) return;
    node* curr;
    
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
