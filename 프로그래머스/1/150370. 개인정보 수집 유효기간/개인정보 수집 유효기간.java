import java.util.*;
import java.io.*;

class Solution {
    // 년, 월을 일로 변환해서 지났는지 지나지 않았는 지 구하기
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        List<Integer> res = new ArrayList<>();

        String[] todaySplit = today.split("[.]");

        int todayToDay = Integer.parseInt(todaySplit[0]) * 12 * 28 +  Integer.parseInt(todaySplit[1]) * 28 + Integer.parseInt(todaySplit[2]);

        Map<Character, Integer> period = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] termSplit = terms[i].split(" ");
            System.out.println(termSplit[0]);
            period.put(termSplit[0].charAt(0), Integer.parseInt(termSplit[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privaciesSplit = privacies[i].split(" ");
            String[] privacyTimeLimit =  privaciesSplit[0].split("[.]");
            int privateTimeToDay = Integer.parseInt(privacyTimeLimit[0]) * 12 * 28 +  Integer.parseInt(privacyTimeLimit[1]) * 28 + Integer.parseInt(privacyTimeLimit[2]);

            if (privateTimeToDay + period.get(privaciesSplit[1].charAt(0)) <= todayToDay) {
                res.add(i + 1);
            }
        }

        // for (int i = 0; i < res.size(); i++) {
        //     System.out.println(res.get(i));
        // }


        return res.stream().mapToInt(i -> i).toArray();
    }
}