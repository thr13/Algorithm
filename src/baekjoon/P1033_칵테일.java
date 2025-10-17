package baekjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1033_칵테일 {
    private static ArrayList<Node>[] arr;
    private static boolean[] visited;
    private static long[] nodeValue;
    private static long lcm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        arr = new ArrayList[n];
        visited = new boolean[n];
        nodeValue = new long[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));

            lcm *= ( p * q / gcd(p, q));
        }

        nodeValue[0] = lcm;
        DFS(0);
        long mgcd = nodeValue[0];

        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, nodeValue[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nodeValue[i] / mgcd + " ");
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, (a % b));
        }
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (Node i : arr[node]) {
            int next = i.getB();

            if (!visited[next]) {
                nodeValue[next] = nodeValue[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}

class Node {
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}