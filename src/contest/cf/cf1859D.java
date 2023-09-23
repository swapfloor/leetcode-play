import java.io.*;
import java.util.*;

// https://codeforces.com/problemset/problem/1859/D

public class Main {
    public static void main(String[] args) {
        int t = nextInt();

        while (t-- > 0) {
            solve();
        }



        printWriter.flush();
    }

    static void solve() {
        // 贪心，找到每个区间最大的范围即可

        int n = nextInt();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            int a = nextInt();
            int b = nextInt();

            list.add(new int[] {l, b});
        }

        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < b[i]) {
                    return -1;
                } else if (a[i] > b[i]) {
                    return 1;
                }
            }
            return 0;
        });

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = list.get(0)[0];
        int right = list.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (right >= list.get(i)[0]) {
                right = Math.max(right, list.get(i)[1]);
            } else {
                treeMap.put(left, right);
                left = list.get(i)[0];
                right = list.get(i)[1];
            }
        }

        treeMap.put(left, right);

        int q = nextInt();

        for (int i = 0; i < q; i++) {
            int query = nextInt();
            Integer got = treeMap.floorKey(query);

            if (got != null) {
                query = Math.max(query, treeMap.get(got));
            }

            printWriter.print(query + " ");
        }

        printWriter.println();
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