import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1. 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        // 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표만 남기기(정규표현식?)
        for (char c : new_id.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
            if (c =='-') {
                sb.append(c);
            }
            if (c == '_') {
                sb.append(c);
            }
            if (c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();


        // 3. 2번이상 .을 하나의 .으로 변환
        new_id = new_id.replaceAll("\\.+", ".");

        // 4. 처음이나 끝에 .이 있으면 제거
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5. 빈문자열이면 a로 치환
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. 15자 이상이면 첫 15자로 자르고, 뒤에 .있을 시 제거
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);


           if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7. 2자 이하라면 길이가 3될때까지 마지막 문자를 이어 붙임
        while(new_id.length() < 3) {
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}