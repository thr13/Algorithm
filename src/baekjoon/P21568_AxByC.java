package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P21568_AxByC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a, b);

        if (c % gcd != 0) {
            System.out.println(-1);
        } else {
            int lots = (int) (c / gcd);
            long[] current = euclidean(a, b);
            System.out.println(current[0] * lots + " " + current[1] * lots);
        }

        br.close();
    }

    private static long[] euclidean(long a, long b) {
        long[] current = new long[2];

        if (b == 0) {
            current[0] = 1;
            current[1] = 0;
            return current;
        }

        long q = a / b;
        long[] prev = euclidean(b, a % b);
        current[0] = prev[1];
        current[1] = prev[0] - (prev[1] * q);

        return current;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return Math.abs(a);
    }
}
