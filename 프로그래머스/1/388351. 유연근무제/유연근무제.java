class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
         int n = schedules.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int notLate = 0;
            
            int arriveHour = (schedules[i] + 10) / 100;

            int arriveMin = (schedules[i] + 10) % 100 / 60;
            int arriveMin2 = (schedules[i] + 10) % 100 % 60;

            // 이게 50이 넘어서 시간이 바뀌어야 할 경우를 고려해야 함.
            int arriveTime = arriveHour * 100 + arriveMin * 100 + arriveMin2;

            for (int j = 0; j < 7; j++) {
                int now = (startday + j) % 7;

                if (now == 6 || now == 0) {
                    continue;
                }

                if (timelogs[i][j] <= arriveTime) {
                    notLate++;
                }
            }
            if (notLate == 5) {
                answer++;
            }
        }
        System.out.println(answer);

        return answer;
    }
}