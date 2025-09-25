package baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        boolean result = true;

        for (int i = 0; i < arr.length; i++) {
            int progression = arr[i];

            if (progression >= num) {
                while (progression >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int arrValue = stack.pop();

                if (arrValue > progression) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sb.toString());
        }
    }
}