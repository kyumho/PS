import java.util.*;

// k시간 m명당 1대
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Integer> server = new ArrayDeque<>();
        
        for (int i = 0; i < 24; i++) {
            
            int requiredServer = players[i] / m;
            
            while (!server.isEmpty() && server.peek() <= i) {
                server.removeFirst();
            }
            
            int current = server.size();
            
             if (current < requiredServer) {
                int need = requiredServer - current;
                answer += need;
                for (int j = 0; j < need; j++) {
                    server.offer(i + k);
                }
            }
        }
        return answer;
    }
}