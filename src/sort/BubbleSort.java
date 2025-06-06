package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 31, 48, 73, 8, 11, 20, 29, 65, 15};

        int last = arr.length;

        for (int i = 0; i < last; i++) {
            for (int j = 1; j < last - i; j++) { // i 를 빼는 이유는 정렬된 것은 끝에 저장하기 때문에 제외하고 정렬을 수행하기 때문이다
                if (arr[j-1] > arr[j]) { // 배열의 왼쪽이 오른쪽보다 값이 클 경우 자리 교체
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < last; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
