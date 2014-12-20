#include <iostream>
#include <stack>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;

typedef vector<string> vs;
typedef vector< vector<string> > vvs;

struct pos {
    string val;
    int cnt;
    pos(): val(""), cnt(0){}
    pos(string s, int a): val(s), cnt(a){}
};

void print(vs tmp) ;
void print(vvs tmp) ;

bool diffOne(string one, string two) {
    int n = one.size();
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
        if (one[i] != two[i])
            ++cnt;
    }
    if (cnt > 1) return false;
    return true;
}

void getPath(string &start, string &end, unordered_set<string> &dict,
             unordered_map<string, unordered_set<string> > &father,
             vector<vector<string> > &ret, vector<string> &path) {
    path.push_back(start);
    if (start == end) {
        ret.push_back(vector<string>(path.rbegin(), path.rend()));
    } else {
        for (auto e : father[start]) {
            getPath(e, end, dict, father, ret, path);
        }
    }
    path.pop_back();
}

void bfs(string start, string end, unordered_set<string> &dict,
         vector<vector<string> > &ret) {
    int len = start.size();
    if (len != end.size() || len == 0 || !start.compare(end) ) return; // invalid

    unordered_set<string> used;
    unordered_set<string> levelUsed;
    unordered_map<string, unordered_set<string> > father; // use it to get path

    queue<string> q;
    q.push(start);
    int levelSize = 1;
    bool found = false;

    while (!q.empty()) {
        string cur = q.front();
        string t(cur);
        q.pop();
        levelSize--;

        for (size_t i = 0; i < len; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (t[i] == c) continue; // itself

                t[i] = c;
                if (t == end) { // find it
                    found = true;
                    father[t].insert(cur);
                    break;
                }

                // t is not used and is in the dict
                if (used.count(t) == 0 && dict.count(t) != 0) {
                    //q.push(t);
                    levelUsed.insert(t);
                    father[t].insert(cur);
                }
            }
            t[i] = cur[i]; // reset t to cur
        }

        if (levelSize == 0) { // finish one level
            if (found) break;
            for (auto e : levelUsed) {used.insert(e); q.push(e);}
            levelSize = q.size();
            levelUsed.clear();
        }
    }

    if (found) {
        vector<string> path;
        getPath(end, start, dict, father, ret, path);
    }

}

vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
    // <string, Queue> contain all the adjacent words that is discover in its previous level
    unordered_map<string, Queue<string> > adjMap;
    int curLen = 0;
    bool found = false;

    vector<vector<string> > r; // results
    Queue<string> queue;
    unordered_set<string> unVisited(dict);
    unordered_set<string> visitedThisLev;
    
    queue.insert(start);
    int currLev = 1;
    int nextLev = 0;

    Queue<string> tmpQueue;
    for(string word: unVisited)
        adjMap[word] = tmpQueue;
    unVisited.earse(start);

    // BFS
    
    
    bfs(start, end, dict, ret);
    return ret;
}

int main()  {
    string start = "hit";
    string end = "cog";
    unordered_set<string> dict = {"hot","dot","dog","lot","log"};

    vvs result;
    findLadders(start, end, dict;
    print(result);

    return 0;
}

void print(vs tmp)  {
    for (auto it = tmp.begin(); it != tmp.end(); ++it)
        cout << *it << ", ";
    cout << endl;
}

void print(vvs tmp)  {
    for (auto it = tmp.begin(); it != tmp.end(); ++it)
        print(*it);
}
