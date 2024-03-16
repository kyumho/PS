import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendIndex = new HashMap<>();

        int friendLength = friends.length;

        for (int i = 0; i < friends.length; i++) {
            friendIndex.put(friends[i], i);
        }  // 맵에 friends의 (이름, 인덱스) 형식으로 저장해놓음

        int[][] giftsChart = new int[friendLength][friendLength];

        for (int i = 0; i < gifts.length; i++) {
            String[] names = gifts[i].split(" ");
            String giver = names[0];
            String receiver = names[1];
            giftsChart[friendIndex.get(giver)][friendIndex.get(receiver)] += 1;
        }

        
        int[] giftGivenCnt = new int[friendLength];
        int[] giftReceivedCnt = new int[friendLength];
        int[] giftScore = new int[friendLength];

        for (int i = 0; i < friendLength; i++) {
            for (int j = 0; j < friendLength; j++) {
                giftGivenCnt[i] += giftsChart[i][j];
            }
        }

        for (int i = 0; i < friendLength; i++) {
            for (int j = 0; j < friendLength; j++) {
                giftReceivedCnt[i] += giftsChart[j][i];
            }
        }
        

        for (int i = 0; i < friendLength; i++) {
            giftScore[i] = giftGivenCnt[i] - giftReceivedCnt[i];
        }

        // 이제 비교하여 선물의 개수를 저장

        int[] nextMonthGift = new int[friendLength];

        for (int i = 0; i < friendLength; i++) {
            for (int j = 0; j < friendLength; j++) {
                if (i == j) {
                    continue;
                }

                if (giftsChart[i][j] > giftsChart[j][i]) {
                    nextMonthGift[i] += 1;
                } else if (giftsChart[i][j] < giftsChart[j][i]) {
                    nextMonthGift[j] += 1;
                } else if (giftsChart[i][j] == giftsChart[j][i]) {
                    // 선물 지수를 비교해줘야 함!!  선물 지수가 높은 사람이 선물을 받음 같다면 둘다 받지 않음
                    if (giftScore[j] < giftScore[i]) {
                        nextMonthGift[i] += 1;
                    } else if (giftScore[j] > giftScore[i]) {
                        nextMonthGift[j] += 1;
                    }
                }
            }
        }

        int answer = -1;

        for (int i = 0; i < friendLength; i++) {
            answer = Math.max(answer, nextMonthGift[i] / 2);
        }


        return answer;
    }
}