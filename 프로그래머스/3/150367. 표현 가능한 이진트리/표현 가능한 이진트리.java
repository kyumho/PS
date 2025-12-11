class Solution {
    // 루트노드가 0인데 리프노트가 1이 있을 때 불가능
    // 십진수인 숫자를 이진수로 변환
    // 변환된 이진수가 트리가 될 수 있는 지 확인
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binary = makeBinary(numbers[i]);

            int len = 1;
            int binaryLen = binary.length();

            while (binaryLen > len) {
                len = len * 2 + 1;
            }

            String treeBinary = "0".repeat(len - binaryLen) + binary;


            boolean rightTree = checkBinary(treeBinary, 0, treeBinary.length() - 1);

            if (rightTree) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    // 십진수 이진수 변환 함수
    private String makeBinary(long number) {

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            sb.append(number % 2);
            number /= 2;
        }

        return sb.reverse().toString();
    }

    private boolean checkBinary(String binary, int start, int end) {
        if (start > end) {
            return true;
        }

        int mid = (start + end) / 2;
        int root = binary.charAt(mid);

        if (root == '0') {
            if (!checkOne(binary, start, mid - 1) || !checkOne(binary, mid + 1, end)) {
                return false;
            }
        }

        if (!checkBinary(binary, start, mid - 1)) {
            return false;
        }

        if (!checkBinary(binary, mid + 1, end)) {
            return false;
        }

        return true;
    }

    private boolean checkOne(String binary, int start, int end) {

        for (int i = start; i <= end; i++) {
            if (binary.charAt(i) == '1') {
                return false;
            }
        }

        return true;
    }
}