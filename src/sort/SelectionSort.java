package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println("선택 정렬전:");
        System.out.println(Arrays.toString(arr));

        selection(arr);

        System.out.println("선택 정렬후:");
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for(int j = i+1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
