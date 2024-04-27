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
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i < N + 1; i++) {

            if (!visited[i]) {
                bfs(i);
                result++;
            }
        }
        System.out.println(result);

    }

    static void bfs(int point) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(point);
        visited[point] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && graph[v][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}