// 먼저 실제로 배열로 쌓음??
// 숫자를 찾아 그 위에 몇개가 있는지 구함?

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        boolean flag = true;
        int m = (n % w == 0) ? (n / w) : (n / w) + 1;
        int[][] arr = new int[m][w];
        int dx = 0;
        int dy = 0;

        int boxNum = 0;

        boolean isRight = true;

        // 배열 구성
        for (int i = m - 1; i >= 0; i--) {
            if (isRight) {
                for (int j = 0; j < w; j++) {
                    boxNum++;
                    if (boxNum > n) {
                        break;
                    }
                    arr[i][j] = boxNum;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    boxNum++;
                    if (boxNum > n) {
                        break;
                    }
                    arr[i][j] = boxNum;
                }
            }
            isRight = !isRight;
        }

        // 디버깅용 출력
        /*for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/

        // 찾고자 하는 택배 숫자 찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == num) {
                    dx = i;
                    dy = j;
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

      while (true) {
            dx--;
            if (dx < 0 || arr[dx][dy] == 0) {
                break;
            }
            answer++;
        }

        System.out.println(answer);

        return answer;
    }
}