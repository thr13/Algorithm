package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948_임계경로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseArr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, time));
            reverseArr.get(end).add(new Node(start, time));
            degree[end]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pre);

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next : arr.get(now)) {
                degree[next.target]--;
                result[next.target] = Math.max(result[next.target], (result[now] + next.value));

                if (degree[next.target] == 0) {
                    queue.offer(next.target);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n + 1];

        queue = new LinkedList<>();
        queue.offer(pos);
        visited[pos] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next : reverseArr.get(now)) {
                if ((result[next.target] + next.value) == result[now]) {
                    count++;

                    if (!visited[next.target]) {
                        visited[next.target] = true;
                        queue.offer(next.target);
                    }
                }
            }
        }

        System.out.println(result[pos]);
        System.out.println(count);
    }

    static class Node {
        int target;
        int value;

        Node (int target, int value) {
            this.target = target;
            this.value = value;
        }
    }
}


