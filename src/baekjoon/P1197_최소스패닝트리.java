package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1197_최소스패닝트리 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        parent = new int[n+1];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        for (int i=0; i<m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            queue.add(new Edge(start, end, value));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < (n-1)) {
            Edge now = queue.poll();

            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int i) {
        if (i == parent[i]) {
            return i;
        } else {
            return parent[i] = find(parent[i]);
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
