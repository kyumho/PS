import java.util.*;
import java.io.*;

class Failure {
    int level;
    double failPercent;

    public Failure(int level, double failPercent) {
        this.level = level;
        this.failPercent = failPercent;
    }
}

class Solution {

    public int[] solution(int N, int[] stages) {
        int totalPlayer = stages.length;

        Map<Integer, Integer> failCnt = new HashMap<>();
        List<Failure> fails = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int stage : stages) {
            failCnt.put(stage, failCnt.getOrDefault(stage, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            int curLevelPlayerCnt = failCnt.getOrDefault(i, 0);
            double failPercent = 0.0;
            if (totalPlayer > 0) {
                failPercent = (double) curLevelPlayerCnt / totalPlayer;
            }
         
            // System.out.println(curLevelPlayerCnt + " " + totalPlayer);
            fails.add(new Failure(i, failPercent));
            totalPlayer -= curLevelPlayerCnt;
        }

         Collections.sort(fails, (a, b) -> {
            if (a.failPercent != b.failPercent) {
                return Double.compare(b.failPercent, a.failPercent);
            }

            return Integer.compare(a.level, b.level);
        });

        int[] answer = new int[fails.size()];

        for (int i = 0; i < fails.size(); i++) {
            answer[i] = fails.get(i).level;
        }

        return answer;
    }
}