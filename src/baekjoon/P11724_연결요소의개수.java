package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    private static List<Integer>[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            arr[vertex].add(edge);
            arr[edge].add(vertex);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int i: arr[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

}
