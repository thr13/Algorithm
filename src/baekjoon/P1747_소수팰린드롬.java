package baekjoon;

import java.util.Scanner;

public class P1747_소수팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i * 2; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        int i = n;

        while(true) {
            if (arr[i] != 0) {
                int result = arr[i];

                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }

            i++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] temp = String.valueOf(target).toCharArray();
        int start = 0;
        int end = temp.length - 1;

        while (start < end) {
            if (temp[start] != temp[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
