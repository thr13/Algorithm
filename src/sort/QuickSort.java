package sort;

public class QuickSort {
    public static int[] arr;
    public static int pivot;

    public static void main(String[] args) {
        arr = new int[] {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};

        System.out.println("기존 배열: ");
        printArray(arr);

        sort(0, arr.length-1);

        System.out.println("정렬 후 배열: ");
        printArray(arr);
    }

    // 배열 출력
    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i: arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    // 정렬
    private static void sort(int start, int end) {
        if (end - start <= 1) { // 분할된 배열의 크기가 1 이하면 재귀 종료
            return;
        }

        int index = partition(start, end); // pivot 의 인덱스

        sort(start, index - 1); // pivot 을 기준으로 왼쪽 배열 정렬
        sort(index, end); // pivot 을 기존으로 오른쪽 배열 정렬
    }

    private static int partition(int start, int end) {
        pivot = arr[end]; // pivot 을 배열의 가장 오른쪽 원소로 선택
        int index = start; // pivot 보다 작거나 같은 원소들이 들어갈 배열의 인덱스

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) { // 현재 배열의 원소가 pivot 보다 작거나 같을 경우
                swap(index, i);
                index++;
            }
        }
        swap(index, end);

        return index;
    }

    // 배열의 두 원소의 자리를 교환
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}