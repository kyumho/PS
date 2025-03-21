import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filtered = new ArrayList<>();
        HashMap<String, Integer> option = new HashMap<>();
        option.put("code", 0);
        option.put("date", 1);
        option.put("maximum", 2);
        option.put("remain", 3);
        
        int selectedOption = option.get(ext);
        int sortOption = option.get(sort_by);
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][selectedOption] < val_ext) {
                filtered.add(data[i]);
            }
        }
        
        filtered.sort((a, b) -> a[sortOption] - b[sortOption]);
        
        int[][] answer = new int[filtered.size()][4];
        
        for (int i = 0; i < filtered.size(); i++) {
            answer[i] = filtered.get(i);
        }
    
        return answer;
    }
}