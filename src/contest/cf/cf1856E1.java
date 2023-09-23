import java.io.*;
import java.util.*;

// https://codeforces.com/problemset/problem/1856/E1

public class Main {
    public static void main(String[] args) {
//        int t = nextInt();
//
//        while (t-- > 0) {
//            solve();
//        }

        solve();


        printWriter.flush();
    }

    static void solve() {
        int n = nextInt();

        List<Integer>[] lists = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int p = nextInt();

            lists[p].add(i);
        }

        printWriter.println(dfs(new int[n + 1], lists, n, 1));
    }

    private static int dfs(int[] size, List<Integer>[] lists, int n, int node) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int results = 0;

        for (int next : lists[node]) {
            results += dfs(size, lists, n, next);
            size[node] += size[next];

            for (int j = n; j >= size[next]; j--) {
                dp[j] |= dp[j - size[next]];
            }
        }

        int node_value = 0;

        for (int j = 1; j <= n / 2; j++) {
            if (dp[j]) {
                node_value = Math.max(node_value, (size[node] - j) * j);
            }
        }

        results += node_value;

        size[node]++;

        return results;
    }

    static PrintWriter printWriter = new PrintWriter(System.out);

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    static String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}