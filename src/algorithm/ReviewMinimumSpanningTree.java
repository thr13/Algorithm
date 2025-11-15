package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewMinimumSpanningTree {
    private static int[] parent;

    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(2, 4, 4));

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);
        int min = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) { // 사이클이 생기지 않는 경우
                union(edge.from, edge.to);
                min += edge.weight;
                count++;

                if(count==n-1) { //
                    break;
                }
            }
        }
        System.out.println("최소 신장 트리 비용: " + min);
    }

    private static int find(int x) {
        if (parent[x] ==x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
