import java.io.*;
import java.util.*;

class Solution {
    // 두 큐의 원소들의 합 / 2
    // 합이 큰 쪽에서 pop을 몇번하면 합이 작은쪽에서 insert
    // 이걸 반복을 최소한으로?
    // 불가능 시 -1
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;

        long sum3 = 0;
        long sum4 = 0;
        Queue<Integer> queue3 = new LinkedList<>();
        Queue<Integer> queue4 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum3 += queue1[i];
            queue3.offer(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            sum4 += queue2[i];
            queue4.offer(queue2[i]);
        }

        long total = sum3 + sum4;
        long half = total / 2;
        long limitLen = queue1.length + queue2.length;

        // todo : queue3과 queue4의 합이 같을 때 까지 큰쪽에서 pop 작은쪽에 insert
        // 반복을 어떻게 하지?

        int flag = 1;

        // 실패 조건
        // pop, insert 횟수가 두 큐의 길이의 합 / 2 보다 많아지면 불가능
        // pop을 했는데 한쪽 큐가 비면 불가능

        // 이렇게 하면 하나씩 pop insert
        while (true) {
            if (answer > limitLen * 2) {
                return -1;
            }

            if (sum3 > sum4) {
                while (sum3 > sum4) {
                    if (queue3.isEmpty() || queue4.isEmpty()) {
                        return -1;
                    }
                    int popNumber = queue3.poll();
                    sum3 -= popNumber;
                    queue4.offer(popNumber);
                    sum4 += popNumber;
                    answer++;
                }
            } else if (sum4 > sum3) {
                while (sum4 > sum3) {
                    if (queue3.isEmpty() || queue4.isEmpty()) {
                        return -1;
                    }
                    int popNumber = queue4.poll();
                    sum4 -= popNumber;
                    queue3.offer(popNumber);
                    sum3 += popNumber;
                    answer++;
                }
            } else if (sum3 == sum4) {
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }
}