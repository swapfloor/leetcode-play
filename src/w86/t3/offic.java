class Solution {
    public List<Integer> splitIntoFibonacci(String x) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, x, 0, 0, 0);
        return res;
    }

    public boolean dfs(List<Integer> res, String x, int st, long faa, long fa) {
        if (st == x.length()) {
            return res.size() >= 3;
        }
        long c = 0;
        for (int i = st; i < x.length(); i++) {
            if (i > st && x.charAt(st) == '0') {
                break;
            }
            c = c * 10 + x.charAt(i) - '0';
            if (c > Integer.MAX_VALUE) {
                break;
            }
            if (res.size() >= 2) {
                if (c < faa + fa) {
                    continue;
                } else if (c > faa + fa) {
                    break;
                }
            }
            res.add((int) c);
            if (dfs(res, x, i + 1, fa, c)) {
                return true;
            }
            res.remove(res.size() - 1);
        }
        return false;
    }
}