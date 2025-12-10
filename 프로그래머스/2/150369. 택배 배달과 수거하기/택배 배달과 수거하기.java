import java.io.*;
import java.util.*;

class Solution {
    // 스택을 사용해서 풀어보기
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = 0;

        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();

        for (int i = 0; i < deliveries.length; i++) {
            deliveryStack.push(deliveries[i]);
        }

        for (int i = 0; i < pickups.length; i++) {
            pickupStack.push(pickups[i]);
        }

        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
           answer += work(cap, n, deliveryStack, pickupStack);
        }

        System.out.println(answer * 2);

        return answer * 2;
    }

    private int work(int cap, int n, Stack<Integer> deliveries, Stack<Integer> pickups) {
        int maxDist = 0;
        int deliverCnt = 0;
        int pickupCnt = 0;
        boolean deliverFirst = true;
        boolean pickupFirst = true;

        // 배달, 수거 각각 cap에 도달할때까지 채우고 최대 거리 계산
        while (cap > deliverCnt && !deliveries.isEmpty()) {
            int nowDeliver =  deliveries.pop();

            if (deliverFirst && nowDeliver > 0) {
                maxDist = Math.max(maxDist, deliveries.size() + 1);
                deliverFirst = false;
            }

            deliverCnt += nowDeliver;
            if (cap < deliverCnt) {
                int left = deliverCnt - cap;
                deliveries.push(left);
                break;
            }
        }

        while (cap > pickupCnt && !pickups.isEmpty()) {
            int nowPickup = pickups.pop();

            if (pickupFirst && nowPickup > 0) {
                maxDist = Math.max(maxDist, pickups.size() + 1);
                pickupFirst = false;
            }

            pickupCnt += nowPickup;
            if (cap < pickupCnt) {
                int left = pickupCnt - cap;
                pickups.push(left);
                break;
            }
        }
        return maxDist;
    }
}