package baekjoon;

import java.io.*;

public class P2751_수정렬하기2 {
    private static int[] arr;
    private static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        temp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);

        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int index1 = start;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= end) {
            if (temp[index1] > temp[index2]) {
                arr[k] = temp[index2];
                k++;
                index2++;
            } else {
                arr[k] = temp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= mid) {
            arr[k] = temp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            arr[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
