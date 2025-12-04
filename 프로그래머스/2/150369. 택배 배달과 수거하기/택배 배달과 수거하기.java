class Solution {
    // 끝에서 배달하고 수거하는게 최소 거리를 보장(?)
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = 0;
        int deliveryLoad = 0;
        int pickupLoad = 0;

        for (int i = n - 1; i >= 0; i--) {
            deliveryLoad += deliveries[i];
            pickupLoad += pickups[i];

            while (deliveryLoad > 0 || pickupLoad > 0) { // 배달, 수거 둘 중 하나가 cap을 넘으면 다시 다녀와야함
                deliveryLoad -= cap;
                pickupLoad -= cap;
                answer += (i + 1) * 2;
            }
        }

        System.out.println(answer);

        return answer;
    }
}