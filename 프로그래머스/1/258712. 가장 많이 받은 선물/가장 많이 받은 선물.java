import java.util.HashMap;
import java.util.Map;

class Solution {
    // 이번달에 선물을 주고 받은 현황 기록
    // 선물 지수 기록
    // 위의 자료를 통해 계산 후 다음달에 가장 선물 return
    public int solution(String[] friends, String[] gifts) {

        int answer = -1;
        int n = friends.length;
        int[][] giftRecord = new int[n][n];
        int[] score = new int[n];

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }

        // 선물 주고 받은 기록, 선물 지수 계산하여 배열로 만듬
        for (int i = 0; i < gifts.length; i++) {
            String[] giftsSplit = gifts[i].split(" ");
            int giverIndex =  index.get(giftsSplit[0]);
            int takerIndex =  index.get(giftsSplit[1]);

            score[giverIndex] += 1;
            score[takerIndex] -= 1;
            giftRecord[giverIndex][takerIndex] += 1;
        }

        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(giftRecord[i][j] + " ");
            }
            System.out.println();
        }
        */

       /*
       for (int i = 0; i < n; i++) {
            System.out.print(score[i] + " ");
        }
       */

        // 선물 받은 개수 계산
        for (int i = 0; i < n; i++ ) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int giveCnt = giftRecord[i][j];
                int takeCnt = giftRecord[j][i];

                if (giveCnt > takeCnt) {
                    cnt++;
                } else if (giveCnt == takeCnt) {
                    if (score[i] > score[j]) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

        return answer;
    }
}