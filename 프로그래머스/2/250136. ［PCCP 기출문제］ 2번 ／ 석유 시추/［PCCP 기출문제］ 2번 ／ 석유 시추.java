import java.util.*;

class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int[] answer = new int[501];

    public int solution(int[][] land) {

        int maxOilCnt = 0;
        int N = land.length;
        int M = land[0].length;
        boolean[][] visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    getOilDistrict(land, i, j, visited);
                }
            }
        }

        Arrays.sort(answer);


        return answer[answer.length - 1];
    }


    private void getOilDistrict(int[][] land, int x, int y, boolean[][] visited) {
        Set<Integer> ySet = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x, y);
        q.offer(p);
        visited[x][y] = true;
        int cnt = 1;
        ySet.add(y);

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];

                if (0 <= nx && nx < visited.length && 0 <= ny && ny < visited[0].length) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        Point nxtP = new Point(nx, ny);
                        ySet.add(ny);
                        q.offer(nxtP);
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        for (int i : ySet) {
            answer[i] += cnt;
        }
    }
}


class Point {
    int x;
    int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}