package sort;

public class RadixSort {
    private static int[] A = {
            123, 2154, 222, 4, 283, 1560, 1061, 2150
    };
    private static int[] tmp = new int[A.length]; // 정렬 결과를 저장할 배열
    private static int n = A.length;

    public static void main(String[] args) {
        System.out.println("기수 정렬 전 배열:");
        printArray(A);

        radixSort(A); // 기수 정렬

        System.out.println("기수 정렬 후 배열:");
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

    // 기수 정렬
    private static void radixSort(int[] A) {
        int max = maxValue(A); // 자리수 계산을 위한 최대값

        for (int k = 1; max / k > 0; k *= 10) { // 1의 자리부터 최대값의 자리까지 반복
            countingSort(A, k);
        }
    }

    // 배열 원소들 중 최대 값 구하기
    private static int maxValue(int[] A) {
        int max = A[0];

        for (int i = 1; i < n; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }

        return max;
    }

    // 자릿수별 정렬
    private static void countingSort(int[] A, int k) {
        int[] count = new int[10]; // 0 부터 9까지 자릿수 빈도수를 저장할 배열

        // 현재 자릿수 카운트
        for (int i = 0; i < n; i++) {
            int digit = (A[i] / k) % 10;
            count[digit]++; // count[digit] 는 해당 숫자의 누적 위치 정보
        }

        // 자릿수 위치 지정
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 현재 자릿수 기준으로 결과 저장(뒤에서 부터 시작)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (A[i] / k) % 10;
            tmp[count[digit] - 1] = A[i];
            count[digit]--;
        }
    }
}
