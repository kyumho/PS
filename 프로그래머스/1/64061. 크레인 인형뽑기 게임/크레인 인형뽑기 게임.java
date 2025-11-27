import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;

        // move의 행 번호 - 1의 행의 0이 아닌것을 stack에 쌓음. 이전에 쌓인것과 동일하면 두개 삭제
        Stack<Integer> dolls = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int colNum = moves[i] - 1;
            int topDoll = 0;

            for (int j = 0; j < n; j++) {
                if (board[j][colNum] != 0) {
                    if (!dolls.isEmpty()) {
                        topDoll = dolls.peek();
                    }
                    if (board[j][colNum] == topDoll) {
                        dolls.pop();
                        answer++;
                    } else {
                        dolls.push(board[j][colNum]);
                    }
                    board[j][colNum] = 0;
                    break;
                }
            }
        }

        System.out.println(answer);

        return answer * 2;
    }
}