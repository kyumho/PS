import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();
        Boolean isOne = true;
        Boolean isZero = true;

        int ones = 0;
        int zeros = 0;


        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) == '1') {
                if (isZero) {
                    ones++;
                }
                isOne = true;
                isZero = false;
            } else {
                if (isOne) {
                    zeros++;
                }
                isZero = true;
                isOne = false;
            }
        }
        
        System.out.println(Math.min(ones, zeros));
    }
}