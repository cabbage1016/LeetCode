public class SolutionGP {
        public int maxProfit(int[] prices) {
            if(prices.length > 0) {
                // 用于记录每种选择在当前位置的最大值
                int[][] memo = new int[prices.length][4];
                // 开始遍历
                for(int i=1; i<prices.length; i++) {
                    // 本次选择买入时，对应的最大值(即前次选择冷冻的最大值)
                    memo[i][0] = memo[i-1][3];
                    // 本次选择卖出时，对应的最大值
                    // 1,前次选择买入时最大值
                    // 2,前次选择持有时最大值
                    // 1,2中取较大的值作为本次卖出的最大值
                    memo[i][1] = Math.max(memo[i-1][0]+prices[i]-prices[i-1], memo[i-1][2]+prices[i]-prices[i-1]+memo[i-1][1]-memo[i-1][2]);
                    System.out.println(memo[i][1]);
                    // 不做赔本买卖(选择卖出值为负值时，将对应值归零)
                    memo[i][1] = Math.max(memo[i][1], 0);
                    System.out.println(memo[i][1]);
                    // 本次选择持有时，对应的最大值(即前次买入 与 前次持有中较大的值)
                    memo[i][2] = Math.max(memo[i-1][0], memo[i-1][2]);
                    System.out.println(memo[i][2]);
                    // 本次选择冷冻时，对应的最大值(即前次卖出 与 前次冷冻中较大的值)
                    memo[i][3] = Math.max(memo[i-1][1], memo[i-1][3]);
                    System.out.println(memo[i][3]);
                    if(i == prices.length-1) {
                        return Math.max(Math.max(memo[i][0], memo[i][1]), Math.max(memo[i][2], memo[i][3]));
                    }
                }
            }
            return 0;
        }
        public static void main(String[] args){
            SolutionGP GP = new SolutionGP();
            int r = GP.maxProfit(new int[]{2,1,2,1,0,1,2});
            System.out.println(r);
        }
}
