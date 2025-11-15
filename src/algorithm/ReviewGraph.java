package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReviewGraph {
    private static List<List<Node>> graph;

    public static void main(String[] args) {
        int n = 5; //  노드 수
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2, 4);
        addEdge(1, 3, 7);
        addEdge(2, 4, 1);
        addEdge(3, 4, 2);

        print();
    }

    private static void addEdge(int from, int to, int weight) {
        graph.get(from).add(new Node(to, weight));
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<graph.size(); i++) {
            sb.append(i);

            for(Node next: graph.get(i)) {
                sb.append("(").append(next.to).append(", 가중치").append(next.weight).append(")");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
