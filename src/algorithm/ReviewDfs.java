package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReviewDfs {
    private static int n; // 노드 개수
    private static int m; // 에지 개수
    private static boolean[] visited; // 방문한 노드 체크
    private static List<Integer>[] graph; // 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1]; // 노드 번호는 1부터 시작하기 때문에 n+1을 넣는다.
        for (int i=1; i<n+1; i++) {
            graph[i] = new ArrayList<>(); // 인접 리스트 초기화
        }

        for (int i=0; i<m; i++) { // 그래프에 에지 추가
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
//            graph[end].add(start); // 무방향 그래프일 경우 추가
        }

        int count = 0;
        for (int i=1; i<n+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        if (visited[node]) { // 이미 방문한 노드일 경우 탐색종료
            return;
        }

        visited[node] = true;

        for (int i: graph[node]) {
            if (!visited[i]) {
                dfs(i); //인접 리스트 중 방문하지 않은 노드만 탐색
            }
        }
    }
}
