package sort;

public class AverageLinearSelect {
    private static int[] A;

    public static void main(String[] args) {
        A = new int[]{31, 8, 48, 73, 11, 3, 20, 29, 65, 15};
        int i = 3; // i 는 3번째 작은수

        int result = select(A, 0, A.length - 1, i);
        System.out.println(i + "번째로 작은수: " + result);
    }

    // 평균 선형 시간 선택 알고리즘
    private static int select(int[] A, int start, int end, int i) {
        if (start == end) {
            return A[start];
        }
        int q = partition(A, start, end); // 분할 알고리즘 실행 -> 결과값으로 pivot 의 index 를 반환
        int k = q - start + 1; // 기준원소가 전체에서 k 번째 작은 원소를 의미

        if (i < k) {
            return select(A, start, q - 1, i);
        } else if (i == k) {
            return A[q];
        } else {
            return select(A, q + 1, end, i - k);
        }

    }

    // 퀵정렬의 분할 알고리즘
    private static int partition(int[] A, int start, int end) {
        int pivot = A[end]; // pivot 은 분할된 배열의 뒷부분을 기준으로 잡음
        int q = start; // q 는 분할된 배열의 첫부분이자 pivot 의 인덱스를 저장할 변수

        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) { // pivot 보다 값이 작거나 같다면, pivot 과 자리를 교체하고 인덱스 q 값을 증가시킴
                swap(A, q, i);
                q++;
            }
        }

        swap(A, q, end);

        return q;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
