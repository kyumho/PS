import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[][] customers = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            customers[i][0] = st.nextToken();
            customers[i][1] = st.nextToken();
        }

        Arrays.sort(customers, new Comparator<String[]>() {

            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(customers[i][0]).append(" ").append(customers[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}