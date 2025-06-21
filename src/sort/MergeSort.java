package sort;

public class MergeSort {
    public static int[] arr, tmp; // 원본 배열, 정렬된 원소를 담을 배열

    public static void main(String[] args) {
        arr = new int[] { 3, 8, 31, 48, 73, 11, 20, 29, 65, 15 };
        tmp = new int[arr.length];

        System.out.println("원본 배열: ");
        printArray(arr); // 원본 배열 출력

        sort(0, arr.length - 1); // 병합 정렬

        System.out.println("정렬 후 배열: ");
        printArray(arr);


    }

    // 배열의 모든 원소 출력
    public static void printArray(int[] arr) {
        StringBuilder stb = new StringBuilder();
        for(int i : arr) {
            stb.append(i).append(" ");
        }
        System.out.println(stb);
    }

    // 재귀적으로 배열 분리 후 병합
    public static void sort(int start, int end) {
        // 배열의 시작 인덱스가 끝 인덱스보다 작을 때만 실행됨
        if (start >= end)
            return;
        int mid = (start + end) / 2;

        sort(start, mid); // 왼쪽 리스트 재귀적 정렬
        sort(mid + 1, end); // 오른쪽 리스트 재귀적 정렬

        merge(start, mid, end); // 정렬된 두 부분을 병합

    }

    // 배열 병합
    public static void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i]; // 원본 배열의 원소를 임시 배열로 복사
        }

        int k = start; // 원본 배열에 병합된 값을 넣을 인덱스
        int index1 = start; // 임시 배열의 왼쪽 리스트 시작 인덱스
        int index2 = mid + 1; // 임시 배열의 오른쪽 리스트 시작 인덱스

        // 왼쪽 리스트와 오른쪽 리스트를 병합
        while (index1 <= mid && index2 <= end) { // 양쪽 그룹의 index 가 가르키는 값을 비교해 더 작은 수를 배열에 저장하고, 해당 배열의 인덱스를 오른쪽으로 한 칸 이동
            if(tmp[index1] > tmp[index2]) { // 왼쪽 리스트의 시작 인덱스가 오른쪽 시작 인덱스보다 클 경우
                arr[k] = tmp[index2];
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= mid) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
