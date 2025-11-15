package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewBellmanFord {
    private static final int INF = 100_000_000; // 무한대 역할
    private static List<Edge> edges = new ArrayList<>(); // 그래프를 에지 리스트로 구현
    private static int[] distance; // 누적 거리

    public static void main(String[] args) {
        int n = 5; // 노드 수
        distance = new int[n+1];

        Arrays.fill(distance, INF); // 누적 거리 초기화
        /*
        // 아래 for 반복문과 똑같지만, Arrays.fill()은 JVM 내부에 네이티브 코드로 구현되어 있어, CPU 사이클을 적게 소모한다.
        for(int i=0; i<n; i++) {
            distance[i] = INF;
        }
         */
        distance[1] = 0; // 출발 노드(1번 정점)는 0 으로 설정

        edges.add(new Edge(1, 2, 6));
        edges.add(new Edge(1, 3, 7));
        edges.add(new Edge(2, 3, 8));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(2, 5, -4));
        edges.add(new Edge(3, 4, -3));
        edges.add(new Edge(3, 5, 9));
        edges.add(new Edge(4, 2, -2));
        edges.add(new Edge(5, 4, 7));

        boolean hasNegativeNumber = bellmanFord(n);

        if (hasNegativeNumber) {
            System.out.println("-1");
        } else {
            for (int i=1; i<=n; i++) {
                System.out.println("1 → " + i + " 최단 거리 = " + distance[i]);
            }
        }
    }

    private static boolean bellmanFord(int n) { // 에지의 최대 개수는 n-1
        for (int i=1; i<=n-1; i++) {
            for (Edge edge: edges) {
                if ((distance[edge.from] != INF) && ((distance[edge.from] + edge.weight) < distance[edge.to])) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) { // 음수 사이클 확인
            if ((distance[edge.from] != INF) && ((distance[edge.from] + edge.weight) < distance[edge.to])) { // 음수 사이클이 존재한다면
                return true;
            }
        }

        return false;
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
