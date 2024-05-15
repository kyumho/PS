
import java.io.*;
import java.util.*;

class Solution {

    // 정점 중 가장 큰 숫자를 찾아 정점의 개수 구하기
    int getNumberOfVertex(int[][] edges) {
        int max = -1;

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (max < edges[i][j]) {
                    max = edges[i][j];
                }
            }
        }
        return max;
    }
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int startV = 0;
        int N = getNumberOfVertex(edges);
        int M = edges.length;

        Map<Integer, Integer> inRecord = new HashMap<>();
        Map<Integer, Integer> outRecord = new HashMap<>();

        // 정점에 연결되어 있는 들어오는 간선과 나가는 간선의 개수를 각각 inRecord, outRecord Map에 담아 준다.
        for (int i = 0; i < M; i++) {
            inRecord.put(edges[i][0], inRecord.getOrDefault(edges[i][0], 0) + 1);
            outRecord.put(edges[i][1], outRecord.getOrDefault(edges[i][1], 0) + 1);
        }

        /*
         시작 노드 : 나가는 간선이 2개 이상 들어오는 간선이 없음.
         막대 모양 : 들어오는 간선이 1개 이상 나가는 간선이 없는 노드가 1개 있음
         8자 모양 : 나가는 간선이 2개, 들어오는 간선이 2개 이상인 노드가 딱 1개 존재
         도넛 모양 : 시작 노드에 연결된 노드의 개수 - 막대 모양의 개수 - 8자 모양의 개수
         */
        for (int i = 1; i < N + 1; i++) {
            int go = inRecord.getOrDefault(i, 0);
            int in = outRecord.getOrDefault(i, 0);

            if (go >= 2 && in == 0) {
                startV = i;
            } else if (in >= 1 && go == 0) {
                answer[2]++;
            } else if (go == 2 && in >= 2) {
                answer[3]++;
            }
        }

        answer[0] = startV;
        answer[1] = inRecord.get(answer[0]) - answer[2] - answer[3];
        

        return answer;
    }
}