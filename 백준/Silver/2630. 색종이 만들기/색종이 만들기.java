import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] answer = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(arr, N, 0, 0);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    // 처음부터 전체 탐색하여 숫자 같으면 1개 다르면 4등분하여 다시 탐색
    public static void solve(int[][] arr, int len, int startX, int startY) {
        int cmp = arr[startX][startY];
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[startX + i][startY + j] != cmp) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            answer[cmp]++;
            return;
        }

        int half = len / 2;

        solve(arr, half, startX, startY);
        solve(arr, half, startX + half, startY);
        solve(arr, half, startX, startY + half);
        solve(arr, half, startX + half, startY + half);
    }
}