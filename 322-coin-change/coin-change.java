import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        // dp[i] = minimum coins needed to make amount i
        int[] dp = new int[amount + 1];

        // amount + 1 acts as "infinity":
        // no valid solution can need more than amount coins
        // when every coin value is at least 1.
        Arrays.fill(dp, amount + 1);

        // Zero coins are needed to make amount 0
        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(
                        dp[currentAmount],
                        dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}