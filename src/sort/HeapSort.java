package sort;

public class HeapSort {
    private static int[] A = new int[]{7, 9, 4, 8, 6, 3}; // 원본 배열
    private static int[] tmp = new int[A.length]; // 정렬된 원소를 저장할 배열
    private static int n = A.length; // 전체 배열의 크기

    public static void main(String[] args) {
        System.out.println("정렬 전 배열:");
        printArray(A);

        buildHeap(A, n); // 배열을 힙으로 만듦
        System.out.println("힙성질을 만족하는 배열:");
        printArray(A);

        sort(); // 힙정렬
        System.out.println("정렬 후 배열:");
        printArray(tmp);
    }

    // 배열 출력
    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    // 힙 속성을 만족하도록 힙수선
    private static void heapify(int[] arr, int i, int n) {
        int smaller = i;
        int leftChild = 2 * i + 1; // 왼쪽 자식 노드 인덱스
        int rightChild = 2 * i + 2; // 오른쪽 자식 노드 인덱스

        if (leftChild < n && arr[leftChild] < arr[smaller]) {
            smaller = leftChild;
        }

        if (rightChild < n && arr[rightChild] < arr[smaller]) {
            smaller = rightChild;
        }

        if (smaller != i) {
            swap(arr, i, smaller);
            heapify(arr, smaller, n);
        }
    }

    // 배열의 원소 교환
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 배열을 힙으로 만듦
    private static void buildHeap(int[] A, int n) {
        // 힙성질을 만족하도록 배열을 수정
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, i, n);
        }
    }

    // 힙정렬
    private static void sort() {
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = A[0];
            A[0] = A[n - 1]; // 힙의 마지막 값을 루트노드로 올림
            n--; // 힙 크기 감소
            heapify(A, 0, n); // 루트노드부터 다시 heapify 적용
        }
    }
}
