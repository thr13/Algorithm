package baekjoon;

import java.util.Scanner;

public class P1717_집합의표현 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (q == 0) {
                union(a, b);
            } else if (q == 1) {
                if (isSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        return a == parent[a] ? a : (parent[a] = find(parent[a]));
    }

    private static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}
