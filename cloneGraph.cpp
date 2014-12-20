#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

struct UndirectedGraphNode {
    int label;
    vector<UndirectedGraphNode*> neighbors;
    UndirectedGraphNode(int x) : label(x) {};
};

UndirectedGraphNode* cloneGraph(UndirectedGraphNode *node) {
    if (!node) return NULL;

    UndirectedGraphNode* head, *curr, *tmp, *ntmp;
    head = new UndirectedGraphNode(node->label);
    curr = head; 
    int n = node->neighbors.size();
    int m; // for neighbor counts
    for(int i = 0; i < n; ++i)
        curr->neighbors[i] = new UndirectedGraphNode(node->neighbors[i]->label);

    // work on the other node's neighbors
    int cnt = 0;
    int cntj = 0;
    for (int i = 0; i < n; ++i) {
        tmp = head->neighbors[i];
        if (node->neighbors[i]->neighbors.size() != 0)  {
            m = node->neighbors[i]->neighbors.size();
            cntj = 0;
            while ( cntj < m)  {
                for (int j = i; j < n; ++j) {
                    if (node->neighbors[j] == node->neighbors[i]->neighbors[cntj])  {
                        tmp->neighbors.push_back(head->neighbors[j]);
                        cntj++;
                    }
                }
            }
        }
    }
    return head;
}

UndirectedGraphNode* buidGraph(int a[], int n) {
    UndirectedGraphNode* head, *curr, *tmp; int cnt;
    for(int i = 0; i < n; ++i) {
        while(a[i] != -1) {
            if (i == 0)  {
                head = new UndirectedGraphNode(a[0]);
                curr = head;
                cnt = 0;
            } else  {
                tmp = new UndirectedGraphNode(a[i]);
                curr->neighbors.push_back(tmp);
            }
        }
        if (a[i] == -1) {
            cnt = i+1;
            continue;
        }
    }
}

void printGraph(UndirectedGraphNode* head) {
    if (!head) {
        cout << "the graph does not exist!" << endl;
        return;
    }
    
    UndirectedGraphNode* curr = head, *tmp = head;
    int cnt = 0;
    
    while(cnt < head->neighbors.size()) {
        cout << curr->label << ", ";
        for (int i = 0; i < curr->neighbors.size(); ++i)
            cout << curr->neighbors[i]->label << ", ";
        cout << endl;
        curr = head->neighbors[cnt++];
    }
}

int main(){
    int n = 3;
    int a[] = {0, 0, 0}; // -1
    
    return 0;
}
