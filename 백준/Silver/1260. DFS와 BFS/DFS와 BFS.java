import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static List<Integer> dfsSeq;

    static List<Integer> bfsSeq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        dfsSeq = new LinkedList<>();
        bfsSeq = new LinkedList<>();


        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st2.nextToken());
            int p2 = Integer.parseInt(st2.nextToken());
            graph[p1][p2] = 1;
            graph[p2][p1] = 1;
        }

        dfs(V);

        for (int seq : dfsSeq) {
            sb.append(seq).append(" ");
        }

        sb.append("\n");

        visited = new boolean[N + 1];

        bfs(V);

        for (int seq : bfsSeq) {
            sb.append(seq).append(" ");
        }
        

        System.out.println(sb);
    }

    static void dfs(int point) {
        if (visited[point]) {
            return;
        }

        visited[point] = true;
        dfsSeq.add(point);

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && graph[point][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int point) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(point);
        visited[point] = true;
        bfsSeq.add(point);

        while (!q.isEmpty()) {
            int p = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && graph[p][i] == 1) {
                    bfsSeq.add(i);
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
