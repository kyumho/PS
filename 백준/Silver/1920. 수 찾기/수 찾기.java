import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        long[] arr2 = new long[M];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            long target = arr2[i];
            boolean flag = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] < target) {
                    start = mid + 1;
                } else if(arr[mid] == target) {
                    System.out.println(1);
                    flag = true;
                    break;
                }
                else {
                    end = mid - 1;
                }
            }
            if (!flag) {
                System.out.println(0);
            }
        }
    }
}