class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
          String answer = "";

        int n = commands.length;

        String[] videoLen = video_len.split(":");

        // 시간을 초로 변환(계산을 위해)
        int videoSecond =  Integer.parseInt(videoLen[0]) * 60 +  Integer.parseInt(videoLen[1]);
        int posSecond = Integer.parseInt(pos.split(":")[0]) * 60 +  Integer.parseInt(pos.split(":")[1]);
        int opStartSecond = Integer.parseInt(op_start.split(":")[0]) * 60 +   Integer.parseInt(op_start.split(":")[1]);
        int opEndSecond = Integer.parseInt(op_end.split(":")[0]) * 60 +   Integer.parseInt(op_end.split(":")[1]);

        // 오프닝 중인지 확인
        if (opStartSecond <= posSecond && posSecond <= opEndSecond) {
            posSecond = opEndSecond;
        }

        for (int i = 0; i < n; i++) {
            if (commands[i].equals("next")) {
                if (videoSecond < posSecond + 10) {
                    posSecond = videoSecond;
                } else {
                    posSecond += 10;
                }
            } else {
                if (posSecond - 10 < 0) {
                    posSecond = 0;
                } else {
                    posSecond -= 10;
                }
            }

            if (opStartSecond <= posSecond && posSecond <= opEndSecond) {
                posSecond = opEndSecond;
            }
        }

        int resMin = posSecond / 60;
        int resSec = posSecond % 60;

        System.out.println(resMin);
        System.out.println(resSec);

        String ansMin = String.format("%02d", resMin);
        String ansSec = String.format("%02d", resSec);

        answer = ansMin + ":" + ansSec;

        System.out.println(answer);

        return answer;
    }
}