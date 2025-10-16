package baekjoon;

import java.util.Scanner;

public class P1016_제곱이아닌수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] isDifference = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long index = min / pow;

            if ((min % pow) != 0) {
                index++;
            }

            for (long j = index; pow * j <= max; j++) {
                isDifference[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;

        for (int i = 0; i <= max - min; i++) {
            if (!isDifference[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
