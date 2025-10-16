package baekjoon;

import java.util.Scanner;

public class P1456_거의소수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] arr = new long[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i * 2; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i < 10000001; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];

                while ((double) arr[i] <= (double) max / (double) temp) {
                    if ((double) arr[i] >= (double) min / (double) temp) {
                        count++;
                    }

                    temp *= arr[i];
                }
            }
        }

        System.out.println(count);
    }
}