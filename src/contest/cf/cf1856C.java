import java.io.*;
import java.util.*;

// https://codeforces.com/problemset/problem/1856/C

public class Main {
    public static void main(String[] args) {
        int t = nextInt();

        while (t-- > 0) {
            solve();
        }



        printWriter.flush();
    }

    static void solve() {
        int n = nextInt();
        int k = nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int low = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, a[i]);
        }

        int high = low + k + 1;

        while (low < high) {
            int mid = (low + high + 1) >>> 1;

            if (check(k, mid, a)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        printWriter.println(low);
    }

    private static boolean check(int limit, int mid, int[] a) {
        int n = a.length;

        if (a[n - 1] >= mid) {
            return true;
        }

        for (int i = n - 2; i >= 0; i--) {
            int need = 0;
            boolean satisfy = false;
            for (int j = i; j < n && need <= limit; j++) {
                if (a[j] >= mid - (j - i)) {
                    satisfy = true;
                    break;
                } else {
                    need += mid - (j - i) - a[j];
                }
            }

            if (satisfy && need <= limit) {
                return true;
            }
        }

        return false;
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