import java.util.*;
import java.io.*;

class Solution {

    class Robot {
        int x;
        int y;
        int moveCnt;

        Robot(int x, int y, int moveCnt) {
            this.x = x ;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }

    public int solution(String[] board) {

        int[] dx = {-1 , 1, 0, 0};
        int[] dy = { 0, 0, -1, 1};

        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];

        int[] robot = findPlace(board, n, m, 'R');
        int robotX = robot[0];
        int robotY = robot[1];

        int[] goal = findPlace(board, n, m, 'G');

        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(robotX, robotY, 0));
        visited[robotX][robotY] = true;

        while (!q.isEmpty()) {
            Robot r = q.poll();

            if (r.x == goal[0] && r.y == goal[1]) {
                System.out.println(r.moveCnt);
                return r.moveCnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = r.x + dx[d];
                int ny = r.y + dy[d];

                int[] place = moveRobot(board, visited, nx, ny, dx[d], dy[d], n, m);

                if (place[0] >= 0 && place[1] >= 0 && place[0] < n && place[1] < m) {
                    if (!visited[place[0]][place[1]]) {
                        visited[place[0]][place[1]] = true;
                        q.offer(new Robot(place[0], place[1], r.moveCnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    private int[] moveRobot(String[] board, boolean[][] visited, int nx, int ny, int dx, int dy, int n, int m) {

        // 첫 칸부터 이동 불가능한 경우 처리
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx].charAt(ny) == 'D') {
            return new int[]{-1, -1}; // 유효하지 않은 위치 반환
        }

        while ((nx + dx >= 0 && ny + dy >= 0 && nx + dx < n && ny + dy < m) && board[nx + dx].charAt(ny + dy) != 'D') {
                nx += dx;
                ny += dy;
        }

        return new int[]{nx, ny};
    }

    private int[] findPlace(String[] board, int n, int m, Character c) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == c) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }
}