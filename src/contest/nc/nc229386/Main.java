// https://ac.nowcoder.com/acm/problem/229386

// 转移公式等于 dp(to) = dp(from)*C(size(to) - 1, size(from))全部相乘。
// 比如6里面分出1，2，2，1，那么就是C(1,1)*C(3,2)*(5,2)*dp(from)全部乘起来，最后一个数字放在最前面因此乘1即可。

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        solve();
        printWriter.flush();
    }

    static void solve() {
        int n = nextInt();

        int[] a = new int[n + 1];
        int[] father = new int[n + 1];
        int[] size = new int[n + 1];
        int[] degree = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            dp[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            father[i] = nextInt();

            if (father[i] == i) {
                father[i] = 0;
            }

            degree[father[i]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int[][] C = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
                }
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            int father_ = father[from];

            degree[father_]--;

            size[father_] += size[from];

            dp[father_] *= C[size[father_] - 1][size[from]] * dp[from];

            if (father_ != 0 && degree[father_] == 0) {
                queue.offer(father_);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (degree[i] > 0) {
                printWriter.println(0);
                return;
            }
        }

        printWriter.println(dp[0]);
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