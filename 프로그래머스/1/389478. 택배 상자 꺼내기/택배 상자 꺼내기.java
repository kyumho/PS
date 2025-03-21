// 먼저 실제로 배열로 쌓음??
// 숫자를 찾아 그 위에 몇개가 있는지 구함?

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = n / w;
        int[][] box = new int[height + 1][w];
        int boxNum = 1;
        boolean nFlag = false;
        for (int i = height; i >= 0; i--) {
            if (i % 2 == 1) {
                for (int j = 0; j < w; j++) {
                    box[i][j] = boxNum;
                    boxNum++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    box[i][j] = boxNum;
                    boxNum++;
                }
            }
        }
        
        int wantBoxHeight = 0;
        
        for (int i = 0; i < height + 1; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(box[i][j]);
                if (box[i][j] == num) {
                    int indexY = j;
                    int indexX = i;
                    while (indexX >= 0) {
                        if (box[indexX][indexY] <= n){
                            answer++;
                        }
                        indexX--;
                    }
                }
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println(answer);
        

        return answer;
    }
}