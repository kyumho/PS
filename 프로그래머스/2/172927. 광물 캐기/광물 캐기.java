// 완전탐색 문제
// 선택할 수 있는 모든 곡갱이의 조합 중 가장 피로도가 낮은 것을 찾아야 함. (백트래킹)
// 종료 조건 시 종료
class Solution {
    private int[][] FATIGUE = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    int minFatigue = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {        
        solve(picks, minerals, 0, 0);
        
        return minFatigue;
    }
    
    private void solve(int[] picks, String[] minerals, int index, int fatigue) {
        // 종료조건 - 사용할 곡갱이가 없거나 광물을 다 캤을 때
        if ((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || index >= minerals.length) {
            minFatigue = Math.min(fatigue, minFatigue);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int newFatigue = fatigue;
                int last = index + Math.min(minerals.length - index, 5);
                
                for (int j = index; j < last; j++) {
                    int mineralIdx = mineralIndex(minerals[j]);
                    newFatigue += FATIGUE[i][mineralIdx];
                }
                
                picks[i] -= 1;
                solve(picks, minerals, last, newFatigue);
                picks[i] += 1;
            }
        }
    }
    
    // 피로도 계산을 위해 광물 인덱스 반환하는 함수
    private int mineralIndex(String mineral) {
        if (mineral.equals("diamond")) {
            return 0;
        } else if (mineral.equals("iron")) {
            return 1;
        } else {
            return 2;
        }
    }
}