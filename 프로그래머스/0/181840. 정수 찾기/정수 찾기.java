import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] num_list, int n) {
        Arrays.sort(num_list);
        int exist = Arrays.binarySearch(num_list, n);
        if (exist >= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}