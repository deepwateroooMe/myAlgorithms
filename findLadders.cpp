#include <iostream>
#include <stack>
#include <vector>
#include <queue>
#include <list>
#include <unordered_map>
#include <unordered_set>
#include <climits>

using namespace std;

typedef vector<string> vs;
typedef vector<vector<string> > vvs;

struct pos {
    string val;
    int cnt;
    pos(): val(""), cnt(0){}
    pos(string s, int a): val(s), cnt(a){}
};

void print(vs tmp) ;
void print(vvs tmp) ;
bool diffOne(string one, string two);
void getPath(string &start, string &end, unordered_set<string> &dict,
             unordered_map<string, unordered_set<string> > &father,
             vector<vector<string> > &ret, vector<string> &path);
void bfs(string start, string end, unordered_set<string> &dict, vector<vector<string> > &ret);

// forgot where I got the above ones, but referred to the methods here
// https://oj.leetcode.com/discuss/9523/share-two-similar-java-solution-that-accpted-by-oj
unordered_map<string, vector<string> > map;
vector<vector<string> > result;
vector<vector<string> >::iterator vvit;
vector<string>::iterator vit;

void backTrace(string word, string start, vector<string> vector) {
    cout << endl << "start: " << start << endl;
    cout << "word: " << word << endl;

    vit = vector.begin();
    if (word.compare(start) == 0) {
        vector.insert(vit, start);

        cout << "vector contents: " << endl;
        cout << "vector.size(): " << vector.size() << endl;
        for (int i = 0; i < vector.size(); ++i)
                cout << vector[i] << ", ";
        cout << endl;
        result.push_back(vector);
        vector.erase(vit);
        
        return;
    }
    vector.insert(vit, word);
    cout << "map.count(word): " << map.count(word) << endl;
    
    if (map.count(word) > 0)
        for (string s : map[word])
            backTrace(s, start, vector);
    vector.erase(vector.begin());
}

vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
    if (dict.size() == 0) return result;

    int min = INT_MAX;
    queue<string> queue;
    queue.push(start);
    
    unordered_map<string, int> ladder;
    ladder[start] = 0;
    for (string s : dict) 
        ladder[s] = INT_MAX;
    
    unordered_set<string>::iterator it = dict.end();
    dict.insert(it, end);
    cout << endl << "print dict: " << endl;
    for (it = dict.begin(); it != dict.end(); it++) 
        cout << *it << ", ";
    cout << endl;

    // BFS: Dijisktra search
    string tmp, word;
    int step;
    while (!queue.empty()) {
        word = queue.front(); // word: start
        queue.pop();
        //cout << "word: " << word << endl;
        step = ladder[word] + 1; // step records # steps to get to WORD
        if (step > min) break;
        for (int i = 0; i < word.size(); ++i) {            
            for (char j = 'a'; j <= 'z'; j++) {
                tmp = word;         
                if (word[i] != j) {
                    tmp[i] = j;      // tmp: new_word
                    if (ladder.count(tmp) > 0) {                    
                        cout << "tmp: " << tmp << endl;
                        if (step > ladder[tmp]) continue;
                        else if (step < ladder[tmp]) {
                            queue.push(tmp);
                            ladder[tmp] = step;   // may have problem here
                        } else; // KEY: if one word appeared in one ladder already,
                        // don't insert the same word insdie teh queue twice, otherwise gets TLE

                        if (map.count(tmp) > 0) {
                            cout << "map.count(tmp): " << map.count(tmp) << endl;
                            
                            auto oit = map.find(tmp);
                            if (oit != map.end()) {
                                /*
                                list<string> newl;
                                for (list<string>::iterator it = map[tmp].begin(); it != map[tmp].end(); ++it) 
                                    newl.push_back(*it);
                                newl.push_back(word);
                                */
                                //map[tmp].insert(map[tmp].end(), word);
                                /*
                                oit->second = newl;
                                for (list<string>::iterator it = newl.begin(); it != newl.end(); ++it) 
                                    cout << *it << ", ";
                                cout << endl;
                                */
                            }

                            /*
                              map[tmp].push_back(word);
                            cout << endl << "print updated vector: " << endl;
                            for (list<string>::iterator it = map[tmp].begin(); it != map[tmp].end(); ++it) 
                                cout << *it << ", ";
                            cout << endl;
                            */
                        } else {
                            vector<string> li;
                            li.push_back(word);
                            map[tmp] = li;
                            cout << endl << "print vector: " << endl;
                            cout << "word: " << word << endl;
                            cout << "tmp: " << tmp << endl;
                            for (vector<string>::iterator it = li.begin(); it != li.end(); ++it) 
                                cout << *it << ", ";
                            cout << endl;
                        }
                        if (tmp.compare(end) == 0) min = step;
                    } 
                }
            }
        }
        //queue.pop();
    }
    
    // BackTracking
    vector<string> results;
    backTrace(end, start, results);
    return result;
}

int main()  {
    string start = "hit";
    string end = "cog";
    unordered_set<string> dict = {"hot","dot","dog","lot","log"};
    
    vvs tmp;
    findLadders(start, end, dict);
    cout << "result.size(): " << result.size() << endl;
    
    print(result);
    cout << "got here B" << endl;

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

