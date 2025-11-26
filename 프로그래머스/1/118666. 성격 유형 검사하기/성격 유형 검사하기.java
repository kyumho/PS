import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
       String answer = "";
        
          Map<Integer, Integer> scoreMap = Map.of(
              1, 3,
              2, 2,
              3, 1,
              4, 0,
              5, 1,
              6, 2,
              7, 3
            );

        Map<Character, Integer> mbti = new HashMap<>();

        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            Character a = survey[i].charAt(0);
            Character b = survey[i].charAt(1);

            int choice = choices[i];

             if (1 <= choice && choice <= 3){
                mbti.put(a, mbti.get(a) + scoreMap.get(choice));
            } else {
                mbti.put(b, mbti.get(b) + scoreMap.get(choice));
            }
        }

//        System.out.println(mbti.get('T'));

        if (mbti.get('R') < mbti.get('T')) {
            answer += 'T';
        } else if (mbti.get('T') <= mbti.get('R')) {
            answer += 'R';
        }

        if (mbti.get('C') < mbti.get('F')) {
            answer += 'F';
        } else if (mbti.get('F') <= mbti.get('C')) {
            answer += 'C';
        }

        if (mbti.get('J') < mbti.get('M')) {
            answer += 'M';
        } else if (mbti.get('M') <= mbti.get('J')) {
            answer += 'J';
        }

        if (mbti.get('A') < mbti.get('N')) {
            answer += 'N';
        } else if (mbti.get('N') <= mbti.get('A')) {
            answer += 'A';
        }

        System.out.println(answer);

        return answer;
    }
}