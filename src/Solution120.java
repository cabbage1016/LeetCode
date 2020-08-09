import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][];
        dp[n] = new int[n+1];
        for (int j = 0; j < n; j++) {
            dp[j] = new int[triangle.get(j).size()];
        }

        for(int i = n-1; i >= 0; --i){
            for(int j = 0;j < triangle.get(i).size(); ++j){
               dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

//    public static void main(String[] args){
//        Solution120 solution120 = new Solution120();
//        solution120.minimumTotal();
//    }


    public static void main(String[] args) throws IOException, IOException {

            List<List<Integer>> triangle = new ArrayList<>();
            List a1 = Arrays.asList(2);
            List a2 = Arrays.asList(3,4);
            List a3 = Arrays.asList(6,5,7);
            List a4 = Arrays.asList(4,1,8,3);

            triangle = Arrays.asList(a1,a2,a3,a4);

            int ret = new Solution120().minimumTotal(triangle);

            String out = String.valueOf(ret);

            System.out.print(out);

    }
}
