import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[] visited;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int point) {
        if (visited[point]) {
            return;
        }

        visited[point] = true;
        for (int i = 1; i < N + 1; i++) {
            if (graph[point][i] == 1) {
                dfs(i);
            }
        }
    }
}