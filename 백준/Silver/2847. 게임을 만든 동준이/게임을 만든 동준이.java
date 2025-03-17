import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                answer += nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
        }

        System.out.println(answer);
    }
}