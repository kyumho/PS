import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int result = 0;
        String[] nums1 = exp.split("-");
        String[] firstNum = nums1[0].split("\\+");

        for (String num : firstNum) {
            result += Integer.parseInt(num);
        }

        int tmp = 0;

        for (int i = 1; i < nums1.length; i++) {
            String[] numbers = nums1[i].split("\\+");
            for (String num : numbers) {
                tmp += Integer.parseInt(num);
            }
            result -= tmp;
            tmp = 0;
        }

        System.out.println(result);
    }
}