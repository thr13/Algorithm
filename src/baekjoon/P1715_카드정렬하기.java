package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            priorityQueue.add(data);
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while (priorityQueue.size() != 1) {
            data1 = priorityQueue.remove();
            data2 = priorityQueue.remove();
            sum += data1 + data2;
            priorityQueue.add(data1 + data2);
        }

        System.out.println(sum);
    }
}
