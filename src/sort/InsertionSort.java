package sort;

// 삽입 정렬
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 31, 48, 73, 11, 20, 29, 65, 15}; // 일부 정렬된 배열

        for (int i = 1; i < arr.length; i++) {
            int newItem = arr[i]; // 삽입할 값(정렬되지 않는 부분의 요소)
            int loc = i - 1; // 일부 정렬된 배열의 마지막 요소

            // 삽입할 값 보다 큰 값들은 한 칸씩 뒤로 밀어냄
            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
            }
            // 삽입할 값 보다 작거나 같을 경우 - 삽입위치이므로 해당 요소의 다음 자리에 삽입함
            arr[loc + 1] = newItem;
        }

        for(int i: arr) {
            System.out.printf(i + " ");
        }
    }
}
