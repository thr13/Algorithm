package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725_트리의부모찾기 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] tree;
    private static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n +1];
        tree = new ArrayList[n +1];
        result = new int[n +1];
        for (int i=0; i<tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i< n; i++) { // 루트 노드가 1로 정해져 있으므로 1부터 n-1 반복
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        dfs(1);

        for (int i = 2; i<= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i: tree[node]) {
            if (!visited[i]) {
                result[i] = node;
                dfs(i);
            }
        }
    }
}
