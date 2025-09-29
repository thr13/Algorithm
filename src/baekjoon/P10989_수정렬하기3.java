package baekjoon;

import java.io.*;

public class P10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr) {
        int[] output = new int[arr.length];
        int radix = 1;
        int count = 0;

        while (count != 5) {
            int[] bucket = new int[10];

            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / radix) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / radix % 10)] - 1] = arr[i];
                bucket[(arr[i] / radix % 10)]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            radix *= 10;
            count++;
        }
    }
}
