package baekjoon;

import java.util.Scanner;

public class P1300_K번째수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long start = 1;
        long end = k;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int i = 1; i<=n; i++) {
                count += Math.min((mid / i), n);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
