import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
          nums.add(Integer.parseInt(st.nextToken()));
        }

        nums.sort(Comparator.naturalOrder());

        int answer = 0;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp += nums.get(i);
            answer += tmp;
        }

        System.out.println(answer);
    }
}