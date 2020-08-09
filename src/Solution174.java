import java.io.IOException;
import java.util.Arrays;

public class Solution174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

        public static void main(String[] args) throws IOException {

                int[][] dungeon = new int[][]{{-2,-3,3}, {-5,-10,1},{10,30,-5}};

                int ret = new Solution174().calculateMinimumHP(dungeon);

                String out = String.valueOf(ret);

                System.out.print(out);

        }
}
