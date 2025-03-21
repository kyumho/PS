import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
            if (bill[0] < bill[1]) {
                bill[1] /= 2;
            } else {
                bill[0] /= 2;
            }
            answer++;
        }
        
        return answer;
    }
}