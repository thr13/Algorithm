package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_버블소트프로그램2 {
    private static int[] arr;
    private static int[] temp;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        temp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(1, n);
        System.out.println(result);
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
                result += index2 - k;
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
