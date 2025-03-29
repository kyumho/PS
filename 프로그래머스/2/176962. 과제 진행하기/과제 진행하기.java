import java.util.*;

class Solution {
    class Schedule {
        String subject;
        int startTime;
        int duration;
        
        public Schedule(String subject, int startTime, int duration) {
            this.subject = subject;
            this.startTime = startTime;
            this.duration = duration;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        List<String> res = new ArrayList<>();
        List<Schedule> plan = new ArrayList<>();
        Deque<Schedule> stopped = new ArrayDeque<>();
        
        for (int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            int toMinute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int duration = Integer.parseInt(plans[i][2]);
            plan.add(new Schedule(plans[i][0], toMinute, duration));
        }
        
        plan.sort((a, b) -> {
            return a.startTime - b.startTime;
        });
        
        for (int i = 0; i < plan.size() - 1; i++) {
            // 처음에 시작 후 다음 꺼 확인, 곂치면 큐에 넣고 다음꺼 실행
            // 1. 다음 시간이랑 안 곂칠때(시간 남음, 시간 남지 않음), 2. 곂칠때
            // 지금, 다음 시간 차, duration 간의 비교 필요
            
            String subject = plan.get(i).subject;
            int timeGap = plan.get(i + 1).startTime - plan.get(i).startTime;
            int duration = plan.get(i).duration;
            if (duration == timeGap) { // 안곂침, 시간 남지 않음
                res.add(subject);
            } else if (duration < timeGap) { // 안곂침, 시간 남음
                res.add(subject);
                int leftTime = timeGap - duration;
                
                    while (!stopped.isEmpty() && leftTime > 0) {
                        Schedule stopSchedule = stopped.pollLast();
                        
                        if (stopSchedule.duration <= leftTime) {
                            leftTime -= stopSchedule.duration;
                            res.add(stopSchedule.subject);
                        } else {
                            int newDuration = stopSchedule.duration - leftTime;
                            leftTime = 0;
                            stopped.offerLast(new Schedule(stopSchedule.subject, stopSchedule.startTime, newDuration));
                        }
                    }
            } else { // 곂침
                stopped.offerLast(new Schedule(subject, plan.get(i).startTime, duration - timeGap));
            }
        }
        
        res.add(plan.get(plan.size() - 1).subject);
        
        while (!stopped.isEmpty()) {
            res.add(stopped.pollLast().subject);
        }
        
        return res.toArray(new String[0]);
    }
}