import java.util.*;
import static java.lang.Math.*;

class Solution {
 public int[] solution(String[] wallpaper) {
        // 가장 왼쪽, 가장 위, 가장 오른쪽, 가장 아래쪽을 구해야함(?)

        int left = 100; // 가장 작은 열을 구해야 함
        int right = -1; // 가장 큰 열을 구해야 함
        int up = 100; // 가장 작은 행을 구해야 함
        int down = -1; // 가장 큰 행을 구해야 함

        int n = wallpaper.length;
        int m = wallpaper[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                }
            }
        }

        System.out.println(up + " " + left + " " + (down + 1) + " " + (right + 1));

        return new int[]{up, left, down + 1, right + 1};
    }
}