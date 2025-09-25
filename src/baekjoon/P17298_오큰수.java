package baekjoon;

import java.io.*;
import java.util.Stack;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i=1; i<n; i++) {
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
