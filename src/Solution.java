import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
        public static void main(String[] args) {

           String a = "11",b = "1";
           String c = addBinary(a,b);
           System.out.println(c);
        }

        public static String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            int temp1, temp2, temp;

            int curr = 0;
            Stack stack = new Stack();
            while (i >= 0 || j >= 0) {
                if (i < 0) {
                    temp1 = 0;
                } else {
                    temp1 = a.charAt(i) - '0';
                }
                if (j < 0) {
                    temp2 = 0;
                } else {
                    temp2 = b.charAt(j) - '0';
                }
                temp = (temp1 + temp2 + curr) % 2;
                stack.push(temp);

                curr = (temp1 + temp2 + curr) / 2;
                --i;
                --j;
            }
            if (curr == 1) {
                stack.push("1");
            }
            StringBuffer result = new StringBuffer();
            while(!stack.empty()){
                result.append(stack.pop());
            }
            return result.toString();

        }
}