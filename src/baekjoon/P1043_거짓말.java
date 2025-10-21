package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P1043_거짓말 {
    private static int[] parent;
    private static int[] knewTrue;
    private static ArrayList<Integer>[] party;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        result = 0;
        knewTrue = new int[t];
        for (int i = 0; i < t; i++) {
            knewTrue[i] = sc.nextInt();
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int size = sc.nextInt();

            for (int j = 0; j < size; j++) {
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            int current = party[i].get(0);

            for (int j=0; j < knewTrue.length; j++) {
                if (find(current) == find(knewTrue[j])) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                result++;
            }
        }

        System.out.println(result);
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

}
