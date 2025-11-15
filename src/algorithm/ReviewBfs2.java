package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 이차원 배열을 이용한 BFS 구현 - 미로찾기
public class ReviewBfs2 {
    private static int[] dx = { 0, 1, 0, -1}; // 행(세로 담당)
    private static int[] dy = { 1, 0, -1, 0}; // 열(가로 담당)
    private static boolean[][] visited;
    private static int[][] arr; // 2차원 배열
    private static int n; // 2차원 배열 행
    private static int m; // 2차원 배열 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String line = st.nextToken();
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j+1)); // 110110 을 한자리씩 배열에 저장
            }
        }
        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j]=true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int k=0; k<4; k++) {
                int x = current[0] + dx[k];
                int y = current[1] + dx[k];

                if (x>=0 && y>=0 && x<n && y<m) { // 배열 범위 확인
                    if (arr[x][y]!=0 && !visited[x][y]) { // 방문할 수 있는 칸 그리고 이전에 방문한 적 없는 칸 인경우
                        visited[x][y] = true; // 방문 표시
                        arr[x][y] = arr[current[0]][current[1]] + 1; // 현재 탐색 중인 칸부터 다음 칸까지 최단 거리 계산 후 배열 저장
                        q.offer(new int[] {x, y}); // 다음 탐색 대상을 큐에 추가
                    }
                }
            }
        }
    }
}
