package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReviewDijkstra {
    private static List<List<Node>> grpah = new ArrayList<>(); // 가중치 그래프 인접리스트
    private static int[] distance; // 최단 거리 배열


    public static void main(String[] args) {
        int n = 5; // 정점 수
        distance = new int[n+1]; // 노드를 1부터 n까지 사용
        for (int i=0; i<=n; i++) {
            grpah.add(new ArrayList<>());
            distance[i]=Integer.MAX_VALUE; // 다익스트라에서 최단 거리 배열의 출발 노드는 0, 그 외는 무한(또는 큰수)로 초기화
        }

        // 무방향 그래프(방향 그래프일 경우 도착~출발 노드 하나 더 생성 필요
        addEdge(1, 2, 4);
        addEdge(1, 3, 7);
        addEdge(2, 4, 1);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);


    }

    private static void addEdge(int from, int to, int weight) {
        grpah.get(from).add(new Node(to, weight));
    }

    private static void dijkstra(int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.weight)
        ); // 누적거리를 담을 큐
        distance[startNode] = 0;
        pq.offer(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int cost = node.weight;

            if (cost > distance[cost]) { // 현재 비용이, 누적 비용보다 크면 무시
                continue;
            }

            for (Node next: grpah.get(to)) { // 인접한 노드 탐색
                int nextCost = cost + next.weight; // 현재 노드와 연결된 인접 노드의 비용 합

                if (nextCost < distance[next.to]) { // 현재 노드와 인접한 노드를 합친 비용이, 시작점 부터 인접 노드까지의 누적 비용보다 작다면, 누적 최단 경로로 설정
                    distance[next.to] = nextCost;
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
