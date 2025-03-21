// 균형잡힌 괄호 u를 구할 stack 활용 함수 필요
// u가 올바른 괄호일 경우 u가 올바른 괄호가 아닐 경우 두가지 경우 고려 필요
// 재귀적으로 단계별로 올바른 괄호를 반환할 함수 필요

import java.io.*;
import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        String s = dfs(p);
        System.out.println(s);
        return s;
    }
    
    public String dfs(String s) {

        if (s.isEmpty()) {
            return "";
        }

        int index = split(s);
        String u = s.substring(0, index);
        String v = s.substring(index);

        if (right(u) && !u.isEmpty()) { // u가 올바른 괄호인 경우
            return s.substring(0 , index) + dfs(v);
        } else { // 아닌 경우(균형잡힌 괄호)
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(dfs(v));
            sb.append(')');
            String uCut = u.substring(1, u.length() - 1);
            for (int i = 0; i < uCut.length(); i++) {
                if (uCut.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }

    public boolean right(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public int split(String s) {
        int right = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '(') {
               right++;
           } else {
               left++;
           }
           if (right == left) {
               return i + 1;
           }
        }
        return s.length();
    }
}