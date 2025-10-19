package baekjoon;

import java.io.*;
import java.util.*;

public class P1325_효율적으로해킹하기 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            answer[i] = BFS(i);
        }

        int maxVal = Arrays.stream(answer).max().getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }

    private static int BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : arr[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }

        return count;
    }
}
