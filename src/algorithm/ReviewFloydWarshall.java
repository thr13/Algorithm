package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReviewFloydWarshall {
    private static int n;
    private static final int INF = 1_000_000_000; // 무한대 역할
    private static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 에지 수
        distance = new int[n+1][n+1]; // 노드는 1번부터 시작하므로 크기를 n+1 로 설정
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0; // 자기 자신의 거리는 0으로 초기화
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            distance[start][end] = weight;
            // distance[end][start] = weight; // 무방향 그래프일 경우 역방향 추가
        }

        floydWarshall(n);
        print();
    }

    private static void floydWarshall(int n) {
        for (int k = 0; k < n; k++) { // k 는 경로상 거쳐가는 노드
            for (int i = 0; i < n; i++) { // i 는 출발노드
                for (int j = 0; j < n; j++) { // j 는 도착노드
                    if ((distance[i][k] + distance[k][j]) < distance[i][j]) { // k 노드로 우회해 도착하는 비용 보다 기존 출발~도착 노드 비용 보다 작다면 업데이트
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}