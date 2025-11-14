package algorithm;

import java.util.PriorityQueue;

public class ReviewGreedy {

    private static int greedy(int[] costs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int cost: costs) {
            pq.offer(cost); // 각 비용을 큐에 삽입
        }

        int total = 0;
        while (pq.size() > 1) { // 큐에 요소가 1개만 남을 때까지 반복
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second; // 현재 비용 합계

            total += sum;
            pq.offer(sum);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] costs = {4, 3, 2, 6};

        int result = greedy(costs);
        System.out.println("최소 합: " + result);
    }
}
