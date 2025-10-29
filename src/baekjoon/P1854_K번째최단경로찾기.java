package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854_K번째최단경로찾기 {
    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        int n, m, k;
        int[][] w = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[n + 1];

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1.equals(o2)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        for (int i = 0; i < n + 1; i++) {
            distanceQueue[i] = new PriorityQueue<>(k, comparator);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            w[a][b] = c;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(1, 0));
        distanceQueue[1].add(0);

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            for (int adjNode = 1; adjNode <= n; adjNode++) {
                if (w[now.node][adjNode] != 0) {
                    if (distanceQueue[adjNode].size() < k) {
                        distanceQueue[adjNode].add(now.cost + w[now.node][adjNode]);
                        priorityQueue.add(new Node(adjNode, now.cost + w[now.node][adjNode]));
                    } else if (distanceQueue[adjNode].peek() > (now.cost + w[now.node][adjNode])) {
                        distanceQueue[adjNode].poll();
                        distanceQueue[adjNode].add(now.cost + w[now.node][adjNode]);
                        priorityQueue.add(new Node(adjNode, now.cost + w[now.node][adjNode]));
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distanceQueue[i].size() == k) {
                bw.write(distanceQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
