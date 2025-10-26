package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516_게임개발하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];
        int[] buildTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == -1) {
                    break;
                }
                arr.get(temp).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : arr.get(now)) {
                degree[next]--;
                result[next] = Math.max(result[next], result[now] + buildTime[now]);

                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
        br.close();
    }
}
