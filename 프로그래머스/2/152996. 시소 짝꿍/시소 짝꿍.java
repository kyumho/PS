import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Integer, Integer> weightCount = new HashMap<>();
        for (int weight : weights) {
            weightCount.put(weight, weightCount.getOrDefault(weight, 0) + 1);
        }
        
        int prev = -1;
        for (int weight : weights) {
            if (weight == prev) {
                continue;
            }
            
            prev = weight;
            
            int count = weightCount.get(weight);
            
            if (count > 1) {
                answer += (long)count * (count - 1) / 2;
            }
            
            if (weightCount.containsKey(weight * 2)) {
                answer += (long)count * weightCount.get(weight * 2);
            }
            
            if (weight % 2 == 0 && weightCount.containsKey(weight * 3 / 2)) {
                answer += (long)count * weightCount.get(weight * 3 / 2);
            }
            
            if (weight % 3 == 0 && weightCount.containsKey(weight * 4 / 3)) {
                answer += (long)count * weightCount.get(weight * 4 / 3);
            }
        }
        
        return answer;
    }
}