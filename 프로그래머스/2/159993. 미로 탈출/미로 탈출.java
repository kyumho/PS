import java.util.*;
import java.io.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();

        String[] map = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        solution.solution(map);
    }
}

class Solution {
    int answer = 200;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        // 시작 지점을 먼저 찾음
        // 레버를 지나 도착지점까지 간 최소 거리를 구함.
        // 최소 거리를 구하는데 가중치가 동일하면 dfs보다 bfs 활용!
        // 못가면 -1 return
        int n = maps.length;
        int m = maps[0].length();

        int[] start = findChar(maps, 'S');
        int[] lever = findChar(maps, 'L');

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int distL = bfs(visited, maps, start[0], start[1], n, m, "L");

        boolean[][] visited2 = new boolean[maps.length][maps[0].length()];
        int distE = bfs(visited2, maps, lever[0], lever[1], n, m, "E");

        System.out.println(distL);
        System.out.println(distE);

        if (distE == -1 || distL == -1) {
            return -1;
        } else {
            return distL + distE;
        }
    }

    private int[] findChar(String[] map, Character c) {
        int n = map.length;
        int m = map[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i].charAt(j) == c) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    private int bfs(boolean[][] visited, String[] map, int x, int y, int n, int m, String opt) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            if (map[q[0]].charAt(q[1]) == 'L' && opt.equals("L")) {
                return q[2];
            }

            if (map[q[0]].charAt(q[1]) == 'E' && opt.equals("E")) {
                return q[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, q[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}