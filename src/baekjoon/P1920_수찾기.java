package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1920_수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i = 0; i<m; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = arr.length-1;

            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = arr[midIndex];

                if (midValue > target) {
                    end = midIndex - 1;
                } else if (midValue < target) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
