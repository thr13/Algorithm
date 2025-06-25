package sort;

import java.util.Arrays;

public class LinearSelect {
    private static int[] A;

    public static void main(String[] args) {
        A = new int[]{31, 8, 48, 73, 11, 3, 20, 29, 65, 15, 5, 55};
        int k = 5; // k는 8번째 작은 원소

        int result = select(A, 0, A.length - 1, k); // 배열에서 i 번째로 작은값
        System.out.println(k + "번째로 작은값: " + result);
    }

    // 최악의 경우 선형 시간 선택 알고리즘
    private static int select(int[] A, int start, int end, int k) {
        if (start == end) {
            return A[start];
        }

        int pivotValue = medianValue(A, start, end); // pivot 값
        int pivotIndex = partition(A, start, end, pivotValue); // 배열에서 pivot 이 존재하는 인덱스
        int pivotOrder = pivotIndex - start + 1; // 전체 배열에서 pivot 순위

        if (k == pivotOrder) {
            return A[pivotIndex];
        } else if (k < pivotOrder) {
            return select(A, start, pivotIndex - 1, k);
        } else {
            return select(A, pivotIndex + 1, end, k - pivotOrder);
        }
    }

    // 분할
    private static int partition(int[] A, int start, int end, int pivotValue) {

        for (int i = start; i <= end; i++) { // pivotValue 와 일치하는 값을 배열 끝으로 이동
            if (A[i] == pivotValue) {
                swap(A, i, end);
                break;
            }
        }

        int pivot = A[end];
        int q = start;

        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                swap(A, i, q);
                q++;
            }
        }
        swap(A, q, end);

        return q;
    }

    // 각 그룹의 중앙값 구하기
    private static int medianValue(int[] A, int start, int end) {
        int n = end - start + 1; // 총 원소의 수

        if (n <= 5) { // 총 원소가 5개 이하인 경우
            Arrays.sort(A, start, end + 1);
            return A[start + n / 2];
        }

        int groupNum = (n + 4) / 5; // 크기가 5인 그룹으로 분할
        int[] medians = new int[groupNum]; // 중앙값들을 모은 배열

        for (int i = 0; i < groupNum; i++) {
            int groupStart = start + (i * 5); // 각 그룹의 시작지점
            int groupEnd = Math.min(groupStart + 4, end); // 각 그룹의 종료지점
            Arrays.sort(A, groupStart, groupEnd + 1); // 그룹별 정렬
            medians[i] = A[groupStart + (groupEnd - groupStart) / 2];
        }

        return medianValue(medians, 0, groupNum - 1);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
