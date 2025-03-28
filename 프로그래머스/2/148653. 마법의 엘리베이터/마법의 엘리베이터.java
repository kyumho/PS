class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int left = storey % 10;
            int nextDigit = (storey / 10) % 10;
        
            if (left < 5) {
                answer += left;
                storey -= left;
            } else if (left > 5) {
                answer += (10 - left);
                storey += (10 - left);
            } else {
                if (nextDigit >= 5) {
                    answer += (10 - left);
                    storey += (10 - left);
                } else {
                    answer += left;
                    storey -= left;
                }
            }
            
            storey /= 10;
        } 
        
        return answer;
    }
}