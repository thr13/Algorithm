package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_이분그래프 {
    private static ArrayList<Integer>[] arr;
    private static int[] check;
    private static boolean[] visited;
    private static boolean isEven;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {
            String[] input = br.readLine().split(" ");
            int vertex = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            arr = new ArrayList[vertex + 1];
            visited = new boolean[vertex + 1];
            check = new int[vertex + 1];
            isEven = true;

            for (int i = 1; i <= vertex; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                arr[start].add(end);
                arr[end].add(start);
            }

            for (int i = 1; i <= vertex; i++) {
                if (isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int i : arr[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
