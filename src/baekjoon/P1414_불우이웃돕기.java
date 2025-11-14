package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414_불우이웃돕기 {
    private static int[] parent;
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> queue = new PriorityQueue();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tempChar = st.nextToken().toCharArray();

            for (int j=0; j<n; j++) {
                int temp=0;

                if (tempChar[j]>='a' && tempChar[j]<='z') {
                    temp = tempChar[j] - 'a' + 1;
                } else if (tempChar[j]>='A' && tempChar[j]<='Z') {
                    temp = tempChar[j] - 'A' + 27;
                }

                sum += temp;

                if (i != j && temp != 0) {
                    queue.add(new Edge(i, j, temp));
                }
            }
        }

        parent = new int[n];
        for (int i=0; i< parent.length; i++) {
            parent[i]=i;
        }

        int useEdge=0;
        int result=0;

        while(!queue.isEmpty()) {
            Edge now = queue.poll();

            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }

        if (useEdge == n-1) {
            System.out.println(sum - result);
        } else {
            System.out.println(-1);
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a!=b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a==parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
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
