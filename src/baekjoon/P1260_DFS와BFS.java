package baekjoon;

import java.io.*;
import java.util.*;

public class P1260_DFS와BFS {
    private static boolean[] visited;
    private static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[n + 1];
        DFS(v);
        System.out.println();

        visited = new boolean[n + 1];
        BFS(v);
    }

    private static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for(int i: arr[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int i : arr[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
