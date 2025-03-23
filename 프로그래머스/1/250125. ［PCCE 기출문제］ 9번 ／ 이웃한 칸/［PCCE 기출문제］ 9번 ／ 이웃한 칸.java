class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int height = board.length;
        int width = board[0].length;
        String color = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (0 <= nx && 0 <= ny && nx < height && ny < width) {
                if (color.equals(board[nx][ny])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}