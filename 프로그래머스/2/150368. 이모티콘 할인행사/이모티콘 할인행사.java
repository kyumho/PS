import java.util.*;
import java.io.*;

class Solution {
    int emoticonPremiumCnt = -1;
    int justPay = 0;
    // 10, 20, 30, 40 이모티콘에 할인율 대입
    // dfs?
    public int[] solution(int[][] users, int[] emoticons) {
        int n = emoticons.length;
        int[] discount = new int[]{10, 20, 30, 40};

        int[] selectedDiscount = new int[n];

        dfs(discount, users, emoticons, 0, selectedDiscount);

        System.out.println(emoticonPremiumCnt);
        System.out.println(justPay);

        return new int[]{emoticonPremiumCnt, justPay};
    }

    private void dfs(int[] discount, int[][] users, int[] emoticons, int depth, int[] selectedDiscount) {

        if (depth == emoticons.length) { // 이모티콘 수 만큼 퍼센트 조합이 나오면 계산
            int premiumCnt = 0;
            int buyPrice = 0;
            for (int i = 0; i < users.length; i++) {
                int spentMoney = 0;
                int buyPercent = users[i][0];
                int priceLimit = users[i][1];
                for (int j = 0; j < emoticons.length; j++) {

                    if (selectedDiscount[j] >= buyPercent) { // 이모티콘 삼
                        spentMoney += (emoticons[j] * (100 - selectedDiscount[j]) / 100);
                    }
                }

                if (spentMoney >= priceLimit) { // 낸 돈이 더 많으면 프리미엄 구독
                    premiumCnt++;
                } else {
                    buyPrice += spentMoney;
                }
            }

            if (premiumCnt > emoticonPremiumCnt) {
                emoticonPremiumCnt = premiumCnt;
                justPay = buyPrice;
            } else if (premiumCnt == emoticonPremiumCnt) {
                if (justPay <= buyPrice) {
                    justPay = buyPrice;
                }
            }

            return;
        }

        for (int j = 0; j < discount.length; j++) {
            selectedDiscount[depth] = discount[j];
            dfs(discount, users, emoticons, depth + 1, selectedDiscount);
        }
    }
}