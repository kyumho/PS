/*
    내림차순 정렬 라이브러리 익히기
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        br.close();

        Collections.sort(numbers, Collections.reverseOrder());

        for (Integer number : numbers) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }
}
