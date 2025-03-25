import java.util.*;

class Solution {
    int sx, sy, mx, my, ex, ey = 0;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        int answer = 100000;
        int n = maps.length;
        int m = maps[0].length();
        char[][] board = new char[n][m];
        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            board[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (board[i][j] == 'L') {
                    mx = i;
                    my = j;
                } else if (board[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        q.add(new int[]{sx, sy, 0, 0});
        visited[sx][sy][0] = true;
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            
            if (node[0] == ex && node[1] == ey && node[3] == 1) {
                answer = node[2];
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];
                
                if (0 <= nx && 0 <= ny && nx < n && ny < m) {
                    if (!visited[nx][ny][node[3]]) {
                        if (board[nx][ny] == 'L') {
                            visited[nx][ny][1] = true;
                            q.offer(new int[]{nx, ny, node[2] + 1, 1});
                        } else if (board[nx][ny] != 'X') {
                            visited[nx][ny][node[3]] = true;
                            q.offer(new int[]{nx, ny, node[2] + 1, node[3]});
                        }
                    }
                }
            }
        }
        
        return answer == 100000 ? -1 : answer;
    }
}