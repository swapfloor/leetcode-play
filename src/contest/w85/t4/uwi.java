// uwi老师的并查集
// [0, n)
// DJSet ds = new DJSet(n);
// ds.union(x, y);
class DJSet {
    public int[] upper;
    public DJSet(int n) {
        upper = new int[n];
        Arrays.fill(upper, -1);
    }
    public int root(int x) {
        return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }
    public boolean equiv(int x, int y) {
        return root(x) == root(y);
    }
    public boolean union(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (upper[y] < upper[x]) {
                int d = x;
                x = y;
                y = d;
            }
            upper[x] += upper[y];
            upper[y] = x;
        }
        return x == y;
    }
    public int count() {
        int ct = 0;
        for (int u : upper)
            if (u < 0)
                ct++;
        return ct;
    }
}

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DJSet ds = new DJSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = 0;
                for (int k = 0; k < strs[i].length(); k++) {
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        diff++;
                    }
                }
                if (diff <= 2) {
                    ds.union(i, j);
                }
            }
        }
        return ds.count();
    }
}
