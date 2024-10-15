#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

// #define MAXN 100000
// // 维护：【差分数组】的前缀和，即 a[i] 数组；与 d[i]*i 数组的、前缀和
// int f[MAXN], ff[MAXN], n; // n 标记： 

// int lowbit(int x) { return x & (-x); }
// // 【单点更新】：更新 i 下标下的值，增量为 v
// void add(int i, int v) {
//     int vi = v * i; // 记住的固定值 
//     while (i <= n) {
//         f[i] += v;
//         // 注意不能写成 ff[k] += k * v，因为 k 的值已经不是原数组的下标了
//         ff[i] += vi;
//         i += lowbit(i); // i 一直在变
//     }
// }
// // 【区间修改、区间加】：对【l,r】区间的、每个下标，增量 v
// void rangeAdd(int l, int r, int v) {
//     // 【差分数组 d[i]】上的操作： d[l]++; d[r+1]--;
//     // d[i]*i 数组：下标 l 增量 l*v; 下标 r+1 增量 (r+1)*(-v)
//     add(l, v);
//     add(r+1, -v);
// }
// // 【区间查询】：【1,i】区间和:
// // 【写错了】：【树状数组】，越大的 idx, 管理的是、越靠后的单个，或是小区间； i-lowbit(i) 后，越往前，管理的是，跨度越大的、靠前的偏小 idx 区间的和
// // 所以，【区间求和、积、异或值】等，需要 idx 前跳，累积所有【分散的、单点，或是小区间】的结果，进最终答案
// int getSum(int* f, int i) { // 传入：查哪个数组的、区间和
//     int r = 0;
//     while (i > 0) { // 【自顶向下】：【TODO】把这里细节再多看几遍
//         r += f[i];
//         i -= lowbit(i);
//     }
//     // while (i <= n) { // 【自底向上】：自叶子节点，一路加到其【根节点】
//     //     r += f[i];
//     //     i += lowbit(i);
//     // }
//     return r;
// }
// // 【对区间、求，和、积、异或值】等：求a[i] 的、闭区间【l,r】的和
// // a[i] 的区间【l,r】的和 = query(1, r) - query(1, l-1)
// long long query (int l, int r) {
//     return getSum(f, r) * (r + 1ll) - getSum(ff, r)
//         // - (getSum(f, l) * l - getSum(ff, l)); // 【写错了】：这行写错了。。
//         - (getSum(f, l-1) * l - getSum(ff, l-1)); // 【写错了】：这行写错了。。
// }

// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// // 【数组实现】：节点序号用 r 计数
// struct Trie {
//     int n[100000][26], r;
//     bool e[100000];  // 该结点结尾的字符串是否存在
//     void insert(char * s, int l) { // 插入字符串 l: s.length()
//         int f = 0, j; // f: father
//         for (int i = 0; i < l; i++) {
//             j = s[i] - 'a';
//             if (!n[f][j])
//                 n[f][j] = ++r; // 开辟：一个新节点
//             f = n[f][j]; // 往后序遍历
//         }
//         e[f] = true; // 【尾巴】记号：是，一个完整串
//     }
//     bool find(char * s, int l) {  // 查找字符串
//         int i = 0, j;
//         for (int k = 0; k < l; k++) {
//             j = s[k] - 'a';
//             if (!n[i][j])
//                 return 0;
//             i = n[i][j];
//         }
//         return e[i]; // 最后，是完整串吗？
//     }
// };

// // 【异或、最大值】：【字典树】插入各数值时，【由高位向低位】插入
// const int N = 100010;
// int h[N], f[N << 1], t[N << 1], w[N << 1], r; // head next tail weight cnter
// // d[i]: 【自顶向下、动规】异或最大值数组
// int n, d[N], n[N << 5][2], tt = 1, ans;       // 亲爱的表哥的活宝妹，没弄明白，这里 tt 与 r 是什么意思  
// // 【TODO】：数组维度、大小定义
// // 【插入】；一个数值 
// void insert(int v) {
//     for (k = 31, i = 0; k >= 0; k--) { // 二进制一位一位向下取
//         int j = ((v >> k) & 1);
//         if (!n[i][j])
//             n[i][j] = ++r; // 新建一个子节点  // <<<<<<<<<<<<<<<<<<<< 
//         i = n[i][j];
//     }
// }
// // 求：与【当前数 v】，异或的【最大可能值】
// // 结果：全局更新入 ans 
// void get(int v) {
//     int r = 0;
//     for (k = 31, i = 0; k >= 0; k--) {
//         int j = ((v >> k) & 1);
//         // if (n[i][j]) { // 【写错了】！！！
//         if (n[i][j ^ 1]) { // 优先判断：于【全局最估】贡献最大的节点，存在吗？
//             i = n[i][j ^ 1]; // 如果能向和当前位不同的子树走，就向那边走【TODO】：亲爱的表哥的活宝妹，这里还是没想明白，明明应该都优先走 1, 它为什么要异或着走？【TODO】
//             r |= (1 << k);
//         } else // 当前这步：全局最优解不存在，【0/1】问题里，就只能走剩余那个了。。
//             i = n[i][j]
//     }
//     ans = Math.max(ans, r);
// }
// void add(int u, int v, int w) {  // 建边: 不知道这里怎么建的。。
//     // f[++r] = u; // <<<<<<<<<<<<<<<<<<<< 这里，一个自长的
//     f[++r] = h[u]; // <<<<<<<<<<<<<<<<<<<< 这里，一个自长的，不明白是什么意思 
//     h[u] = r; // head[v] = u
//     t[r] = v; // tail[u] = v
//     w[r] = w;
// }
// // 【记忆化深搜】：【自顶向下】动态更新？？
// // void dfs(int u, int fa) { // 【TODO】：下午再写这个，看不懂
// //     int i = h[u]; // node idx for u
// // }
// void dfs(int u, int fa) {
//     insert(d[u]);
//     get(d[u]);
//     for (int i = h[u]; i; i = n[i]) {  // 遍历子节点
//         int v = t[i];
//         if (v == fa) continue;
//         d[v] = d[u] ^ w[i];
//         dfs(v, u);
//     }
// }
// // int main() {
// //     cin.tie(nullptr)->sync_with_stdio(false);
// //     cin >> n;
// //     for (int i = 1; i < n; ++i) {
// //         int u, v, w;
// //         cin >> u >> v >> w;
// //         add(u, v, w);  // 双向边
// //         add(v, u, w);
// //     }
// //     dfs(1, 0);
// //     cout << ans;
// //     return 0;
// // }

// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// // 【前缀自动机】：跟【前缀函数】 prefix_function(string s) 极像！！可是，它有什么、任何不一样呢？
// // 【沉默的、无限中转、一次跳到位】：还记得那个【多字符串匹配、AC自动机】fail 指针仙人跳，一步跳到位吗？
// void compute_automaton(string s, vector<vector<int>>& f) { // 【自动机】：二维向量，传地址
//     s += '#';
//     int n = s.size();
//     vector<int> pi = prefix_function(s);
//     f.assign(n, vector<int>(26)); // 【自动机初始化】：相当于是【二维数组】
//     for (i = 0; i < n; i++) 
//         for (k = 0; k < 26; k++) {
//             // int j = i;
//             // while (j > 0 && 'a' + k != s[j])
//             //     j = pi[j-1];
//             // if ('a' + k == s[j]) j++;
//             // f[i][k] = j;

//             // 我们可以应用【动态规划】来利用表中已计算过的部分。
//             // 【动规】把上面的 while O(N) 变成了 O(1), 想要【查询结果的子问题】，先前已经【计算过、存储着】拿来直用！！
//             // 只要我们从值 j 变化到 pi[j - 1]，那么我们实际上在说转移 (j, c) 所到达的状态同转移 (pi[j - 1], c) 一样，
//             // 但【该答案 f[pi[j-1]][c]】，我们之前已经精确计算过了
//             if (i > 0 && 'a' + k != s[i]) // 一个 if 不是 while: 它是怎么，1 步跳到位的？
//                 f[i][k] = f[pi[i-1]][k]; // f[i][j] 自动机，每个格位点，存放的是，O(1) 复杂度【1 步跳到位】的【最大长度】？是这样的！！
//             else
//                 // f[i][k] = f[j][k]; // 【写错了】：自动机，这里写错了
//                 f[i][k] = i + ('a' + k == s[i]); // 感觉，这些细节，要找个题目， debug 一下才能够，真正看懂
//         }
//  }

// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// // 亲爱的表哥的活宝妹，晚上狠快就要睡着了。。。
// // 【图论】：在亲爱的表哥的活宝妹，感觉原本狠简单，如【链条链表、二叉树、天下的各种树、各种图】。。可是狠久没写过，就会忘记；另则，基础不是狠牢固，也是捡捡芝麻知识点。。。
// // 晚上的时间，亲爱的表哥的活宝妹，晚上的脑袋不怎么转、、写写玩玩儿，写几个破烂小函数，不要睡着了。。
// // 亲爱的表哥的活宝妹，晚上脑袋不怎么转，今天晚上，就把【图论】机器里的样码，照葫芦画飘地写一写，回想一下。晚上不要睡着了就可以
// vector<vector<bool>> f;
// vector<bool> v;
// int n, m;
// bool find_edge(int i, int j) {
//     return f[i][j];
// }
// void dfs(int i) {
//     if (v[i]) return ;
//     v[i] = true;
//     for (int j : f[i]) { // 【写错了？】没写错，但要判断，连边存在 f[i][j]=[0,1] 只有值为1 时，才有边连接着
//     // for (j = 1; j <= n; j++) {
//         if (f[i][j]) // 前提：要存在【i,j】连边，
//             dfs(j);
//     }
// }
// // 【用栈、实现、DFS】
// void dfs(int u) {
//     stack<int> s;
//     s.push(u);
//     v[u] = true;
//     while (!s.empty()) {
//         int i = s.top();
//         s.pop();
//         for (int j : f[i]) 
//             if (!v[j]) {
//                 v[j] = true;
//                 s.push(j); // 就相当于，【递归调用 dfs(j)】：把一个【子节点】的遍历，DFS 一路走到底！！
//             }
//     }
// }
// // 【递归调用、实现、DFS】：极简单
// void dfs(int i) {
//     v[i] = true;
//     for (int j : f[i]) {
//         if (!v[j])
//             dfs(j);
//     }
// }
// // 【链式前向星】：真鬼魂。。鬼知道，这是什么玩意儿。。。
// // head[u] 和 cnt 的初始值都为 -1
// // 添加一条【u,v】连边
// void add(int u, int v) { // 【TODO】：不明白，这个 r 计数器，是怎么连的。。。
//     next[++r] = head[u]; // 当前边的后继
//     head[u] = r; // 起点 u 的第一条边
//     to[r] = v;   // 当前边的终点
// }
// // 遍历 u 的出边
// for (int i = head[u]; ~i; i = next[i]) { // ~i 表示 i != -1
//     int v = to[i];
// }

// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
#include <iostream>
#include <vector>

using namespace std;

// vector<int> head, next, to;
// vector<bool> v;
// int n, m;
// void add(int u, int v) {
//     next.push_back(head[u]); //head[u] 是什么。。 
//     head[u] = to.size();
//     to.push_back(v);
// }
// bool find_edge(int u, int v) {
//     for (int i = head[u]; ~i; i = next[i]) {  // ~i 表示 i != -1
//         if (to[i] == v) {
//             return true;
//         }
//     }
//     return false;
// }
// void dfs(int u) {
//     if (v[u]) return;
//     v[u] = true;
//     for (int i = head[u]; ~i; i = next[i]) dfs(to[i]);
// }
// int main() {
//     cin >> n >> m;
//     v.resize(n + 1, false);
//     head.resize(n + 1, -1);
//     for (int i = 1; i <= m; ++i) {
//         int u, v;
//         cin >> u >> v;
//         add(u, v);
//     }
//     return 0;
// }

// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 亲爱的表哥的活宝妹，先把今天早上、才看懂的【KMP? Z 数组写一遍】：快速睡着了。。。
