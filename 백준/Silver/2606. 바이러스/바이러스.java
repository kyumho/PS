import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1][p2] = 1;
            graph[p2][p1] = 1;
        }

        dfs(1);

        System.out.println(result - 1);
    }

    static void dfs(int point) {

        if (visited[point]) {
            return;
        }

        visited[point] = true;
        result++;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && graph[point][i] == 1) {
                dfs(i);
            }
        }
    }
}