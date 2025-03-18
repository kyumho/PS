import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (n1, n2) -> {
            if (n1[0] == n2[0]){
                return n1[1] - n2[1];
            }
            return n1[0] - n2[0];
        });

        pq.offer(time[0][1]);

        int endTime = time[0][1];
        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty()){
                endTime = pq.peek();
            }

            if (endTime <= time[i][0]) {
                pq.poll();
                pq.offer(time[i][1]);
            } else {
                pq.offer(time[i][1]);
            }
        }

        System.out.println(pq.size());
    }
}