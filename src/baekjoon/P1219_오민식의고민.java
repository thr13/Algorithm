package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219_오민식의고민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[m];
        long[] distance = new long[n];
        long[] cost = new long[n];

        Arrays.fill(distance, Long.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        distance[startCity] = cost[startCity];

        for (int i = 0; i <= n + 50; i++) {
            for (int j = 0; j < m; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                long money = distance[start] + cost[end] - price;

                if (distance[start] == Long.MIN_VALUE) {
                    continue;
                } else if (distance[start] == Long.MAX_VALUE) {
                    distance[end] = Long.MAX_VALUE;
                } else if (distance[end] < money) {
                    distance[end] = money;

                    if (i >= n - 1) {
                        distance[end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (distance[endCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (distance[endCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[endCity]);
        }

    }

    private static class Edge {
        int start;
        int end;
        int price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }

}
