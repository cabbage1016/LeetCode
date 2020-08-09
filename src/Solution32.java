import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> judge = new Stack<Integer>();
        judge.push(-1);
        int max = 0;
        for(int i = 0;i < s.length();++i){
            if('(' == (s.charAt(i))){
                judge.push(i);

            }else {
                judge.pop();
                if(judge.empty()){
                    judge.push(i);
                }else {

                    max = Math.max(max,i-judge.peek());
                }
            }
        }
        return max;
    }

//    public static String stringToString(String input) {
//        if (input == null) {
//            return "null";
//        }
//        return Json.value(input).toString();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            //String s = stringToString(line);

            int ret = new Solution32().longestValidParentheses(line);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}


