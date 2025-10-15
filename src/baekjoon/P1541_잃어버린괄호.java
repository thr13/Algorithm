package baekjoon;

import java.util.Scanner;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split("-");
        int result = 0;

        for (int i = 0; i < str.length; i++) {
            int temp = sum(str[i]);

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }

    private static int sum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
