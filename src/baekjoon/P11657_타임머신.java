package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신 {
    private static int n, m;
    private static long[] distance;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m + 1];
        distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                if ((distance[edge.start] != Integer.MAX_VALUE) && (distance[edge.end] > (distance[edge.start] + edge.time))) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean cycle = false;
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if ((distance[edge.start] != Integer.MAX_VALUE) && (distance[edge.end] > (distance[edge.start] + edge.time))) {
                cycle = true;
            }
        }

        if (!cycle) {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    private static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
