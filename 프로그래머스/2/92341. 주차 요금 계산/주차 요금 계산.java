import java.io.*;
import java.util.*;

class Solution {
    // 기록을 순회하면서 Map 자료구조 활용해서 관리 String : 분으로 환산한 시간
    // In일때 기록 Out일때 찾아서 계산해서 요금을 또 다른 Map에서 관리
    // 마지막에 차량 순서대로 정렬한 뒤 하나씩 찾아서 int 배열에 담아서 return
    public int[] solution(int[] fees, String[] records) {
        Set<String> inOutRecord = new HashSet<>();
        Map<String, Integer> timeRecords = new HashMap<>();
        Map<String, Integer> feeRecords = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        int timeLimit = 23 * 60 + 59;

        // 누적 시간 기록
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String[] time = record[0].split(":");

            int toMinute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (record[2].equals("IN")) {
                inOutRecord.add(record[1]);
                timeRecords.put(record[1], toMinute);
            } else if (record[2].equals("OUT")) {

                int inTime = timeRecords.getOrDefault(record[1], 0);
                int stayTime = toMinute - inTime;
                int totalTimeTmp = totalTime.getOrDefault(record[1], 0);

                inOutRecord.remove(record[1]);

                totalTime.put(record[1], stayTime + totalTimeTmp);
            }
        }

        if (!inOutRecord.isEmpty()) {
            for (String carNumber : inOutRecord) {
                int inTime = timeRecords.get(carNumber);
                int left = timeLimit - inTime;
                int totalTimeTmp = totalTime.getOrDefault(carNumber, 0);

                totalTime.put(carNumber, left + totalTimeTmp);
            }
        }

        // 누적시간 확인해서 요금 계산 후 map에 기록
        for (String carNumber : totalTime.keySet()) {
            int fee = 0;
            int stayTime = totalTime.get(carNumber);

            if (fees[0] < stayTime) { // 기본 시간 이상일때
                fee += fees[1]; // 기본 요금 더하기

                int leftTime =  stayTime - fees[0];

                int leftMoney = (leftTime / fees[2]) * fees[3];
                fee += leftMoney;

                if (leftTime % fees[2] != 0) {
                    fee += fees[3];
                }

                feeRecords.put(carNumber, fee);
            } else {
                feeRecords.put(carNumber, fees[1]);
            }
        }

        int[] answer = feeRecords.entrySet().stream().sorted(Map.Entry.comparingByKey()).mapToInt(Map.Entry::getValue).toArray();

        return answer;
    }
}