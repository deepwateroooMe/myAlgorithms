struct pos {
    string val;
    int cnt;
    pos(): val(""), cnt(0){}
    pos(string s, int a): val(s), cnt(a){}
};

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

bool bfs(unordered_set<string> &dict, string start, string end, int &cnt) {
    queue<pos> q;
    q.push(pos(start, 1));
    string tmp, s;
    unordered_map<string, bool> visited;
    pos one;
    
    while (!q.empty())  {
        one = q.front();
        start = one.val;
        for (int i = 0; i < start.size(); ++i) {
            for (char j = 'a'; j <= 'z'; j++) {
                tmp = start;
                if (start[i] != j) {
                    tmp[i] = j;
                    if ( dict.find(tmp) != dict.end()) {
                        if (visited.count(tmp)) continue;
                        if (diffOne(tmp, end))  {
                            cnt = one.cnt + 2;
                            return true;
                        }
                        q.push(pos(tmp, one.cnt+1));
                        visited[tmp] = true;
                    }
                }
            }
        }
        q.pop();
    }
    cnt = 0;
    return false;

}
    
int ladderLength(string start, string end, unordered_set<string> &dict) {
    if (diffOne(start, end)) return 2;
    if ( dict.empty() && !diffOne(start, end) ) return 0;


    int cnt = 1;
    bool done = bfs(dict, start, end, cnt);
    if (done) return cnt;
    return 0;
}
