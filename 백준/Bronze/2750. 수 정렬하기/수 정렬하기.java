/*
 BufferedReader 활용해 입력 받는 법 숙지
 Arrays.sort() 라이브러리 숙지
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(answer);

        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }
}