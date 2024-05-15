class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int attackTime = attacks[0][0];
        int leftHealth = health - attacks[0][1];

        if (leftHealth <= 0) {
            return -1;
        }

        for (int i = 1; i < attacks.length; i++) {
            int skillCnt = 0;
            for (int j = attackTime + 1; j < attacks[i][0]; j++) {
                if (leftHealth + bandage[1] <= health) {
                    leftHealth += bandage[1];
                } else {
                    leftHealth = health;
                }
                skillCnt++;
                if (skillCnt >= bandage[0]) {
                    if (leftHealth < health) {
                        leftHealth += bandage[2];
                    }
                    skillCnt = 0;
                }
            }
            attackTime = attacks[i][0];
            leftHealth -= attacks[i][1];

            if (leftHealth <= 0) {
                return -1;
            }
        }

        System.out.println(leftHealth);

        return leftHealth;
    }
}