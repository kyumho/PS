
/*
 StringBuilder를 활용해 출력 하는 법 숙지
 Collections.sort() 라이브러리 숙지
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

        Collections.sort(numbers);

        for (Integer number : numbers) {
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }
}
