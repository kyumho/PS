import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets;
        int caseNumber = 0;

        while ((brackets = br.readLine()).charAt(0) != '-'){
            Stack<Character> st = new Stack<>();
            int res = 0;

            for (int i = 0; i < brackets.length(); i++) {
                char bracket = brackets.charAt(i);
                if (bracket == '{') {
                    st.push(bracket);
                } else {
                    if (st.empty()){
                        res++;
                        st.push('{');
                    } else {
                        st.pop();
                    }
                }
            }

            res += (st.size() / 2);
            caseNumber++;
            System.out.println(caseNumber + ". " + res);
        }
    }
}
