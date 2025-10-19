package baekjoon;

import java.util.*;

public class P18352_특정거리의도시찾기 {
    private static int[] visited;
    private static ArrayList<Integer>[] arr;
    private static int n, m, k, x;
    private static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        arr = new ArrayList[n + 1];
        answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
        }

        visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }

        BFS(x);

        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);

            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : arr[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
