package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P13023_ABCDE {
    private static List<Integer>[] arr;
    private static boolean[] visited;
    private static boolean arrive;

    public static void main(String[] args) {
        arrive = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int vertex = sc.nextInt();
            int edge = sc.nextInt();
            arr[vertex].add(edge);
            arr[edge].add(vertex);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void DFS(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;

        for (int i : arr[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
