package baekjoon;

import java.util.Scanner;

public class P2018_수들의합5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != n) {
            if (sum == n) {
                count++;
                endIndex++;
                sum = sum + endIndex;
                System.out.printf("[sum==n]count: %d, sum: %d, startIndex: %d, endIndex: %d\n", count, sum, startIndex, endIndex);
            }
            else if (sum > n) {
                sum = sum - startIndex;
                startIndex++;
                System.out.printf("[sum>n]count: %d, sum: %d, startIndex: %d, endIndex: %d\n", count, sum, startIndex, endIndex);
            }
            else {
                endIndex++;
                sum = sum + endIndex;
                System.out.printf("[sum<n]count: %d, sum: %d, startIndex: %d, endIndex: %d\n", count, sum, startIndex, endIndex);
            }
        }
        System.out.println(count);
    }
}
