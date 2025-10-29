package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로구하기 {
    private static int v, e, k;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<Edge>[] list;
    private static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        distance = new int[v + 1];
        visited = new boolean[v + 1];
        list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        queue.add(new Edge(k, 0));
        distance[k] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;

            for (int i = 0; i < list[currentVertex].size(); i++) {
                Edge tmp = list[currentVertex].get(i);
                int next = tmp.vertex;
                int value = tmp.value;

                if (distance[next] > (distance[currentVertex] + value)) {
                    distance[next] = value + distance[currentVertex];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }

    }

    private static class Edge implements Comparable<Edge> {
        private int vertex;
        private int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
