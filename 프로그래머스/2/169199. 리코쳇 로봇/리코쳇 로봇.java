import java.util.*;
import java.io.*;

class Solution {
    class Node {
        int x;
        int y;
        int cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean findRobot = false;
        int startX = 0;
        int startY = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                    findRobot = true;
                    break;
                }
            }
            if (findRobot) {
                break;
            }
        }
        
        q.add(new Node(startX, startY, 0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                while (0 <= nx && 0 <= ny && nx < n && ny < m && board[nx].charAt(ny) != 'D') {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                nx -= dx[d];
                ny -= dy[d];
                
                if (board[nx].charAt(ny) == 'G') {
                    return cur.cnt + 1;
                }
                
                if (board[nx].charAt(ny) == '.' && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
        
        return -1;
    }
}