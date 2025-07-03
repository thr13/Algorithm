package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String strNum = br.readLine();
        br.close();
        char[] chNum = strNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chNum[i] - '0';
        }
        System.out.print(sum);
    }
}