import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                if (n1[0] != n2[0]) {
                    return n1[0] - n2[0];
                }

                return n1[1] - n2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(point[i][0]).append(" ").append(point[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}