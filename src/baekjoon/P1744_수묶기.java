package baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();

            if (data > 1) {
                plusQueue.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusQueue.add(data);
            }
        }

        int sum = 0;

        while (plusQueue.size() > 1) {
            int first = plusQueue.remove();
            int second = plusQueue.remove();
            sum += (first * second);
        }

        if (!plusQueue.isEmpty()) {
            sum += plusQueue.remove();
        }

        while (minusQueue.size() > 1) {
            int first = minusQueue.remove();
            int second = minusQueue.remove();
            sum += (first * second);
        }

        if (!minusQueue.isEmpty()) {
            if (zero == 0) {
                sum += minusQueue.remove();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
