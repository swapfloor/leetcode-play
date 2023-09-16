class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> size(n);
        vector<int> ans(n);
        function<void(int, int, int)> dfs1 = [&](int x, int fa, int depth) {
            size[x] = 1;
            ans[0] += depth;
            for (auto y : g[x]) {
                if (y != fa) {
                    dfs1(y, x, depth + 1);
                    size[x] += size[y];
                }
            }
        };
        dfs1(0, 0, 0);
        function<void(int, int)> dfs2 = [&](int x, int fa) {
            for (auto y : g[x]) {
                if (y != fa) {
                    ans[y] = ans[x] + n - 2 * size[y];
                    dfs2(y, x);
                }
            }
        };
        dfs2(0, 0);
        return ans;
    }
};
