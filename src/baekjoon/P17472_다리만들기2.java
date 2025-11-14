package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17472_다리만들기2 {
    private static final int[] dr = { -1, 0, 1, 0};
    private static final int[] dc = { 0, 1, 0, -1};

    private static int[] parent;
    private static int[][] map;

    private static int n, m, num;
    private static boolean[][] visited;

    private static final ArrayList<ArrayList<int[]>> allIslands = new ArrayList<>();
    private static ArrayList<int[]> island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = 1;
        for (int i = 0; i < n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    num++;
                    allIslands.add(island);
                }
            }
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for (ArrayList<int[]> nowNode : allIslands) {
            for (int[] node : nowNode) {
                int row = node[0];
                int column = node[1];
                int now_island = map[row][column];

                for (int d = 0; d < 4; d++) {
                    int tempRow = dr[d];
                    int tempColumn = dc[d];
                    int length = 0;

                    while ((row + tempRow >= 0) && (row + tempRow < n) && (column + tempColumn >= 0) && (column + tempColumn < m)) {
                        if (map[row + tempRow][column + tempColumn] == now_island) {
                            break;
                        } else if ((map[row + tempRow][column + tempColumn] != 0)) {
                            if (length > 1) {
                                queue.add(new Edge(now_island, map[row + tempRow][column + tempColumn], length));
                            }
                            break;
                        } else {
                            length++;
                        }

                        if (tempRow < 0) {
                            tempRow--;
                        } else if (tempRow > 0) {
                            tempRow++;
                        } else if (tempColumn < 0) {
                            tempColumn--;
                        } else if (tempColumn > 0) {
                            tempColumn++;
                        }
                    }
                }
            }
        }

        parent = new int[num];
        for (int i=0; i< parent.length; i++) {
            parent[i]=i;
        }

        int useEdge = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            Edge nowEdge = queue.poll();
            if (find(nowEdge.start) != find(nowEdge.end)) {
                union(nowEdge.start, nowEdge.end);
                result += nowEdge.value;
                useEdge++;
            }
        }

        if (useEdge == num - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a!=b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a==parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        island = new ArrayList<>();

        int[] start = {i, j};
        queue.add(start);
        island.add(start);

        visited[i][j] = true;
        map[i][j] = num;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int column = now[1];

            for (int d=0; d<4; d++) {
                int tempRow = dr[d];
                int tempColumn = dc[d];

                while ((row + tempRow >= 0) && (row + tempRow < n) && (column + tempColumn >= 0) && (column + tempColumn < m)) {
                    if (!visited[row + tempRow][column + tempColumn] && map[row + tempRow][column + tempColumn] != 0) {
                        addNode(row + tempRow, column + tempColumn, queue);
                    } else {
                        break;
                    }

                    if (tempRow < 0) {
                        tempRow--;
                    } else if (tempRow > 0) {
                        tempRow++;
                    } else if (tempColumn < 0) {
                        tempColumn--;
                    } else if (tempColumn > 0) {
                        tempColumn++;
                    }
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = num;
        visited[i][j] = true;

        int[] temp = {i, j};
        island.add(temp);
        queue.add(temp);
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
