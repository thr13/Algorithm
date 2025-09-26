package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];
        for (int i=0; i<n; i++) {
            data[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(data);

        int max = 0;
        for (int i=0; i<n; i++) {
            if (max < data[i].index - i) {
                max = data[i].index - i;
            }
        }
        System.out.println(max+1);
    }

    static class Data implements Comparable<Data>{
        int value;
        int index;

        public Data(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}
