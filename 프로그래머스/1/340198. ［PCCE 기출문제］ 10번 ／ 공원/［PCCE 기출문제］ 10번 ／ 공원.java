import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 남는 공간 중 가장 크기가 큰 정사각형의 길이를 찾아야 함
        // 필요한 알고리즘: 완전 탐색(?)
        int answer = -1;

        int n = park.length;
        int m = park[0].length;

        Integer[] matsCopy = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsCopy, Collections.reverseOrder());

        for (int i = 0; i < matsCopy.length; i++) {
            if (answer != -1)
                break;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int length = matsCopy[i];
                    boolean success = true;

                    if (park[j][k].equals("-1")) {
                        for (int l = 0; l < length; l++) {
                            for (int r = 0; r < length; r++) {
                                if (j + l < n && k + r < m) {
                                    if (!park[j + l][k + r].equals("-1")) {
                                        success = false;
                                        break;
                                    }
                                } else {
                                    success = false;
                                    break;
                                }
                            }
                            if (!success) {
                                break;
                            }
                        }
                        if (success) {
                            answer = length;
                        }
                    }
                }
                if (answer != -1) {
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}