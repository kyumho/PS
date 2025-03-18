import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            for (int j = 0; j < 2; j++) {
                pq.add(n1 + n2);
            }
        }

        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        System.out.println(res);
    }
}