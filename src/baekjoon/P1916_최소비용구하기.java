package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용구하기 {
    private static int n, m;
    private static ArrayList<Node>[] list;
    private static int[] distance;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        visit = new boolean[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.targetNode;

            if (!visit[now]) {
                visit[now] = true;

                for (Node n : list[now]) {
                    if (!visit[n.targetNode] && distance[n.targetNode] > (distance[now] + n.value)) {
                        distance[n.targetNode] = distance[now] + n.value;
                        queue.add(new Node(n.targetNode, distance[n.targetNode]));
                    }
                }
            }
        }

        return distance[end];
    }

    private static class Node implements Comparable<Node> {
        int targetNode;
        int value;

        Node(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}