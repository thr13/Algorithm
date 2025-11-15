package baekjoon;

import java.util.Scanner;

public class P1991_트리순회 {
    private static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2]; // 0, 왼쪽 자식 노드1, 오른쪽 자식노드2
        for (int i=0; i<n; i++) {
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            if (right =='.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int node) {
        if (node == -1) {
            return;
        }
        System.out.print((char) (node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    private static void inOrder(int node) {
        if (node == -1) {
            return;
        }
        inOrder(tree[node][0]);
        System.out.print((char) (node + 'A'));
        inOrder(tree[node][1]);
    }

    private static void postOrder(int node) {
        if (node == -1) {
            return;
        }
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char) (node + 'A'));
    }
}
