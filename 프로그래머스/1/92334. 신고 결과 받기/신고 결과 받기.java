import java.util.*;

class Solution {

    // 누가 누구를 신고한지 파악 필요
    // 신고 당한 사람들중 신고한 사람이 있는지 파악 필요
    // 자료구조, 구현
    public static int[] solution(String[] id_list, String[] report, int k) {

        List<Integer> res = new ArrayList<>();

        // 1. 신고 중복은 제거
        String[] distinctReport = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String, List<String>> reportRecord = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        List<String> banned = new ArrayList<>();

        // 2. 신고 기록 map으로 관리
        for (int i = 0; i < distinctReport.length; i++) {
            String[] distinctReportSplit = distinctReport[i].split(" ");

            String reporter = distinctReportSplit[0];
            String criminal = distinctReportSplit[1];

            reportRecord.putIfAbsent(reporter, new ArrayList<>());
            reportRecord.get(reporter).add(criminal);
            reportCount.put(criminal, reportCount.getOrDefault(criminal, 0) + 1);
        }

        // 3. 정지 당한 사람 구하기
        for (String reporter : reportCount.keySet()) {
            if (reportCount.get(reporter) >= k) {
                banned.add(reporter);
            }
        }

        // 4. 정지당한 사람과 신고 기록 비교
        for (int i = 0; i < id_list.length; i++) {
            String checkPerson = id_list[i];
            List<String> cmpList = reportRecord.getOrDefault(checkPerson, new ArrayList<>());
            int alarmCnt = 0;
            for (int j = 0; j < cmpList.size(); j++) {
                for (int l = 0; l < banned.size(); l++) {
                    if(cmpList.get(j).equals(banned.get(l))) {
                       alarmCnt++;
                    };
                }
            }
            res.add(alarmCnt);
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}