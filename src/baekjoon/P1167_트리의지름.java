package baekjoon;

import java.util.*;

public class P1167_트리의지름 {
    private static boolean[] visited;
    private static int[] distanceArray;
    private static ArrayList<Edge>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        arr = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int vertex = sc.nextInt();
            while (true) {
                int edge = sc.nextInt();

                if (edge == -1) {
                    break;
                }

                int distance = sc.nextInt();
                arr[vertex].add(new Edge(edge, distance));
            }
        }
        distanceArray = new int[v + 1];
        visited = new boolean[v + 1];

        BFS(1);

        int max = 1;
        for (int i = 2; i <= v; i++) {
            if (distanceArray[max] < distanceArray[i]) {
                max = i;
            }
        }
        distanceArray = new int[v + 1];
        visited = new boolean[v + 1];

        BFS(max);

        Arrays.sort(distanceArray);
        System.out.print(distanceArray[v]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Edge i : arr[node]) {
                int destination = i.destination;
                int weight = i.weight;

                if (!visited[destination]) {
                    visited[destination] = true;
                    queue.add(destination);
                    distanceArray[destination] = distanceArray[node] + weight;
                }
            }
        }
    }
}

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
