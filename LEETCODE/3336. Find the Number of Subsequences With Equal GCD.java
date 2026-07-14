import java.util.Arrays;

class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1000000007;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // dp[g1][g2] stores the count of valid disjoint subsequences with GCDs g1 and g2
        int[][] dp = new int[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;

        // Precompute GCD values to optimize inner loop iterations
        int[][] gcdTable = new int[maxVal + 1][maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            for (int j = 0; j <= maxVal; j++) {
                gcdTable[i][j] = gcd(i, j);
            }
        }

        for (int x : nums) {
            int[][] nextDp = new int[maxVal + 1][maxVal + 1];
            
            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0) continue;

                    long count = dp[g1][g2];

                    // Choice 1: Skip the current number x
                    nextDp[g1][g2] = (int) ((nextDp[g1][g2] + count) % MOD);

                    // Choice 2: Add x to the first subsequence (seq1)
                    int ng1 = gcdTable[g1][x];
                    nextDp[ng1][g2] = (int) ((nextDp[ng1][g2] + count) % MOD);

                    // Choice 3: Add x to the second subsequence (seq2)
                    int ng2 = gcdTable[g2][x];
                    nextDp[g1][ng2] = (int) ((nextDp[g1][ng2] + count) % MOD);
                }
            }
            dp = nextDp;
        }

        // Aggregate counts where g1 == g2 and both subsequences are non-empty (g > 0)
        long totalPairs = 0;
        for (int g = 1; g <= maxVal; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
