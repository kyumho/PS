import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = findStart(park);
        int n = park.length;
        int m = park[0].length();

        Map<String, int[]> direction = new HashMap<>();

        direction.put("E", new int[]{0, 1});
        direction.put("S", new int[]{1, 0});
        direction.put("W", new int[]{0, -1});
        direction.put("N", new int[]{-1, 0});

        int sx = start[0];
        int sy = start[1];

        for (int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");

            boolean success = true;

            int dx = direction.get(route[0])[0];
            int dy = direction.get(route[0])[1];

            int moveCnt = Integer.parseInt(route[1]);

            for (int j = 1; j <= moveCnt; j++) {
                int nx = sx + dx * j;
                int ny = sy + dy * j;

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (park[nx].charAt(ny) == 'X') {
                        success = false;
                        break;
                    }
                } else {
                    success = false;
                    break;
                }
            }

            if (success) {
                sx += (dx * moveCnt);
                sy += (dy * moveCnt);
            }
        }

        System.out.println(sx);
        System.out.println(sy);

        return new int[]{sx, sy};
    }

    private int[] findStart(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                   return new int[]{i, j};
                }
            }
        }

        return new int[]{0 ,0};
    }
}