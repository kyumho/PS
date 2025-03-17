import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = new LinkedList<>();
        List<Character> chars = new LinkedList<>();
        String exp = br.readLine();

        String tmp = "";
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != '-' && exp.charAt(i) != '+') {
                tmp += exp.charAt(i);
            } else {
                nums.add(Integer.parseInt(tmp));
                chars.add(exp.charAt(i));
                tmp = "";
            }
        }

        if (tmp.length() != 0){
            nums.add(Integer.parseInt(tmp));
        }

        int res = nums.get(0);
        boolean isMinus = false;
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == '-') {
                isMinus = true;
                res -= nums.get(i + 1);
            } else {
               if (isMinus) {
                   res -= nums.get(i + 1);
               } else {
                   res += nums.get(i + 1);
               }
            }
        }

        System.out.println(res);

    }
}